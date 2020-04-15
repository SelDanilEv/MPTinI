package by.belstu.it.Selitsky.Lab;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket server = new ServerSocket(7072);
            System.out.println("initialized");
            while (true) {
// ожидание клиента
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName()
                        + " connected");
                /*
                 * создание отдельного потока для обмена данными
                 * с соединившимся клиентом
                 */
                ServerThread thread = new ServerThread(socket);
// запуск потока
                thread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
