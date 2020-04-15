package by.belstu.it.Selitsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        //-------------------------------
//        // define id
//        InetAddress currentIP = null;
//        InetAddress[] currentsIP = null;
//        byte ip[] = {(byte) 192, (byte) 168, (byte) 56, (byte) 1};
//        currentIP = InetAddress.getLocalHost();
//        currentIP = InetAddress.getByName("Defender-SD");
//
//        currentsIP = InetAddress.getAllByName("Defender-SD");
//        currentIP = InetAddress.getByAddress(ip);
//        if(currentIP != null)
//        System.out.println(currentIP);
//        //-------------------------------

        //-------------------------------
////     from domen
//        InetAddress currentIP = null;
//        InetAddress belstuIP = null;
//        try {
//            currentIP = InetAddress.getLocalHost();
//// вывод IP-адреса локального компьютера
//            System.out.println("IP -> " + currentIP.getHostAddress());
//            belstuIP = InetAddress.getByName("www.belstu.by");
//// вывод IP-адреса БГУ www.belstu.by
//            System.out.println("BSTU -> " + belstuIP.getHostAddress());
//        } catch (UnknownHostException e) {
//// если не удается найти IP
//            System.err.println("адрес недоступен " + e);
//        }
//        //-------------------------------


        //Определение доступа
// задание IP-адреса в виде массива
//        byte ip[] ={(byte)123, (byte)162, (byte)204, (byte)87};
//        try {
//            InetAddress addr = InetAddress.getByAddress("Unknow", ip);
//            System.out.println(addr.getHostName()
//                    + "-> cоединение:" + addr.isReachable(100));
//        } catch (UnknownHostException e) {
//            System.err.println("адрес недоступен " + e);
//        } catch (IOException e) {
//            System.err.println("ошибка " + e);
//        }

//////        read kode from site
//        URL tut = null;
//        String urlName = "http://www.tut.by";
//        try {
//            tut = new URL(urlName);
//        } catch (MalformedURLException e) {
//// некорректно заданы протокол, доменное имя или путь к файлу
//            e.printStackTrace();
//        }
//        if (tut == null) {
//            throw new RuntimeException();
//        }
//        try (BufferedReader d = new BufferedReader
//                (new InputStreamReader(tut.openStream()))) {
//            String line = "";
//            while ((line = d.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String urlName = "http://www.onliner.com";
//        int timeout = 10_000;
//        URL url;
//        try {
//            url = new URL(urlName);
//            final URLConnection connection = url.openConnection();
//// установка таймаута на соединение
//            connection.setConnectTimeout(timeout);
//            System.out.println(urlName + " content type: "+
//                    "\n" + connection.getContentType()+
//                    "\n" +connection.getClass()+
//                    "\n" + connection.getContentLength());
//// продолжение извлечения информации из соединения
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Socket socketClient = new Socket("128.34.56.3", 8030);

        ServerSocket serverSocket = null;
        Socket client = null;
        BufferedReader inbound = null;
        OutputStream outbound = null;
        List<String> gr3 = new ArrayList<String>();
        gr3.add("Mihail");
        gr3.add("Alexandr");
        gr3.add("Lena");
        gr3.add("Nikita");
        try {
// Создаем server socket
            serverSocket = new ServerSocket(3000);
            System.out.println("Waiting for a student request...");
            while (true) {
// Ждем запрос
                client = serverSocket.accept();
// Получаем поток
                inbound = new BufferedReader(new
                        InputStreamReader(client.getInputStream()));
                outbound = client.getOutputStream();
                String symbol = inbound.readLine();
//Генерируем студента
                String student = gr3.get((int) (Math.random() * 3));
                outbound.write(("\n The top student of " + symbol +
                        " is " + student + "\n").getBytes());
                System.out.println("Request for " + symbol +
                        " has been processed - the top student of "
                        + symbol + " is " + student + "\n");
                outbound.write("End\n".getBytes());
            }
        } catch (IOException ioe) {
            System.out.println("Error in Server: " + ioe);
        } finally {
            try {
                inbound.close();
                outbound.close();
            } catch (Exception e) {
                System.out.println("FitServer:can't close streams" + e.getMessage());
            }
        }
    }
}
