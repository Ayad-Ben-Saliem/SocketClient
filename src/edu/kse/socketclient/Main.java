package edu.kse.socketclient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        // Connect to server
        String ip = "localhost";
        int port = 4444;
        Socket socket = new Socket(ip, port);

        Scanner scanner = new Scanner(socket.getInputStream());
        ChattingSession session1 = new ChattingSession(scanner, System.out);

        scanner = new Scanner(System.in);
        PrintStream printer = new PrintStream(socket.getOutputStream());
        ChattingSession session2 = new ChattingSession(scanner, printer);

        session1.start();
        session2.start();

    }
}
