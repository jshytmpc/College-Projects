package pexer2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PreExercise2 {
    public static void main(String[] args) {
        // Initialized variables
        int port = 3000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();

            
            // Instantiate reader for Client message
            BufferedReader streamReader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

            // Instantiate writer for Client
            PrintWriter streamWriter = new PrintWriter(
                clientSocket.getOutputStream(), true);
            
            // Server serves message to client
            streamWriter.println("What is your name? ");

            // Server then accepts input from the client
            String name = streamReader.readLine();

            int age;

            // Validate age for voting
            while (true) {
                streamWriter.println("What is your age? ");
                try {
                    age = Integer.parseInt(streamReader.readLine());
                    if (age <= 0) {
                        throw new NumberFormatException();
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    streamWriter.println(e);
                    continue;
                }
            }
            
            if (age >= 18) {
                streamWriter.println(name + ", you are in the legal age to apply for a Driver's License");
            } else {
                streamWriter.println(name + ", you are still to young to apply for a Driver's License");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
