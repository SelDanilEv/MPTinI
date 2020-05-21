package by.belstu.it.Selitsky.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 implements AbstractClient {

    public static String name;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        try {
// установка соединения с сервером
            Scanner scan = new Scanner(System.in);
            socket = new Socket(InetAddress.getLocalHost(), 7072);
            String response = "";
            String tmp = " ";
            PrintStream ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread update = new Thread(
                    new Runnable() {
                        BufferedReader br2;
                        public Runnable init(BufferedReader b){
                            br2 = b;
                            return this;
                        }
                        @Override
                        public void run() {
                            String tmp2 = "";
                            while(true) {
                                try {
                                    if ((tmp2 = br2.readLine()) != null)
                                        System.out.println(tmp2);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }.init(br)
            );
            update.start();

            while (!response.equals("exit")) {
                tmp = scan.nextLine();
                if (!tmp.equals("")) {
                    response = tmp;
                    ps.println("Client 2: " + response);
                }
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetName() {
        return name;
    }
}