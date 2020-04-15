package by.belstu.it.Selitsky.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

class ServerThread extends Thread {
    private PrintStream os; // передача
    private PrintStream myos; // передача
    private BufferedReader is; // прием
    private InetAddress addr; // адрес клиента
    private Socket mysoc;

    public void disconnect() {
        try {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
            System.out.println(addr.getHostName() + " disconnecting");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }

    static ArrayList<Socket> sockets = new ArrayList<>();

    public ServerThread(Socket s) throws IOException {
        sockets.add(s);
        mysoc = s;
        myos = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        addr = s.getInetAddress();
    }

    static StringBuilder AllChat;

    public void run() {
        String str;
        if (AllChat == null)
            AllChat = new StringBuilder("");
        try {
            while ((str = is.readLine()) != null) {
                if (!str.substring(10).equals(" ")) {
                    for (Socket soc : sockets) {
                        if (mysoc.getPort() != soc.getPort()) {
                            os = new PrintStream(soc.getOutputStream());
                            os.println(str);
                        }
                    }
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
// если клиент не отвечает, соединение с ним разрывается
            System.err.println("Disconnect");
        } finally {
            disconnect(); // уничтожение потока
        }
    }
}
