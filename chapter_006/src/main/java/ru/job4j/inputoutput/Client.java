package ru.job4j.inputoutput;

import java.io.*;
import java.net.Socket;

/**
 * Socket.
 * Client.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.02.2019
 *@version 0.1
 */
public class Client {

    private final Socket socket;
    private static final String EXIT = "exit";

    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * Client startup.
     */
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String command = null;
            do {
                System.out.println("Enter a message to the server: ");
                command = reader.readLine();
                out.println(command);
                if (!EXIT.equals(command)) {
                    String response = null;
                    do {
                        response = in.readLine();
                        if (response == null) {
                            break;
                        }
                        System.out.println(response);
                    } while (!response.isEmpty());
                }
            } while (!EXIT.equals(command));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
