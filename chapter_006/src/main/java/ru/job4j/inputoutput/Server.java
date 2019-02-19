package ru.job4j.inputoutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket.
 * Server.
 *@author IvanPJF (teaching-light@yandex.ru)
 *@since 18.02.2019
 *@version 0.1
 */
public class Server {

    private final Socket socket;
    private static final String EXIT = "exit";
    private static final String HELLO = "hello";
    private static final String LN = System.lineSeparator();

    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Server startup.
     */
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true)
        ) {
            String command = null;
            do {
                System.out.println("Waiting for command...");
                command = in.readLine();
                if (HELLO.equals(command)) {
                    out.println("Hello, dear friend. I'm a oracle." + LN);
                } else if (!EXIT.equals(command)) {
                    out.println("I don't understand you." + LN);
                }
            } while (!EXIT.equals(command));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
