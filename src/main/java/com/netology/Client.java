package com.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

    public static void main(String[] args) throws IOException {

        try (Socket clienSocket = new Socket("netology.homework", Server.PORT);
//             PrintWriter writer = new PrintWriter(clienSocket.getOutputStream(), true);
//             BufferedReader reader = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))
             ) {
//             writer.println("Hello form Alex!");
//             System.out.println("Сервер мне говорит: " + reader.readLine());


            BufferedReader input = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clienSocket.getOutputStream(), true);

            String message = input.readLine();
            System.out.println(message);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            String name = consoleInput.readLine();
            output.println(name);

            message = input.readLine();
            System.out.println(message);

            String answer = consoleInput.readLine();
            output.println(answer);

            message = input.readLine();
            System.out.println(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
