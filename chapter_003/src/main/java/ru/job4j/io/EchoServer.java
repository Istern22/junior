package ru.job4j.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Collectors;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     var in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (!str.isEmpty()) {
                        if (str.equals("GET /?msg=Bye HTTP/1.1")) {
                            socket.close();
                            server.close();
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}