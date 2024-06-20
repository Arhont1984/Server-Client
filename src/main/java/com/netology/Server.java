package com.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

    public static final Integer PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер стартовал");

            while (true) {
                try (Socket clienSocket = serverSocket.accept();
//                     PrintWriter printWriter = new PrintWriter(clienSocket.getOutputStream(), true);
//                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))
                ) {

//                    String infoFromClient = bufferedReader.readLine();
//                    System.out.printf("Новое подключение принято. Инофрмация: %s, порт: %d%n", infoFromClient, clienSocket.getPort());
//                    printWriter.printf("Привет из Англии! Твой порт: %d%n", clienSocket.getPort());
                    BufferedReader input = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
                    PrintWriter output = new PrintWriter(clienSocket.getOutputStream(), true);
                    output.println("Write your name:");
                    String name = input.readLine();

                    output.println("Are you child? (yes/no):");
                    String answer = input.readLine();

                    if (answer.equals("yes")) {
                        output.println("Welcome to the kids area, " + name + "! Let's play!");
                    } else {
                        output.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}