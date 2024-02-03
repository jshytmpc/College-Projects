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
            System.out.println("Server is running at port " + port);
            Socket clientSocket = serverSocket.accept();
            
            // Instantiate reader for Client message
            BufferedReader streamReader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

            // Instantiate writer for Client
            PrintWriter streamWriter = new PrintWriter(
                clientSocket.getOutputStream(), true);
            
            while (clientSocket.isConnected()) {
                streamWriter.println();
                streamWriter.println("|-------------------|");
                streamWriter.println("  Driver's License");
                streamWriter.println("   Age Validator");
                streamWriter.println("|-------------------|");
                streamWriter.println();
                
                // Server serves message to client
                streamWriter.println("What is your name? ");
                // Server then accepts input from the client
                String name = streamReader.readLine();
                streamWriter.println();
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
                        streamWriter.println();
                        streamWriter.println("Error: Please input numbers only");
                        streamWriter.println();
                        continue;
                    }
                }
                
                if (age >= 18) {
                    streamWriter.println();
                    streamWriter.println(name + ", you are in the legal age to apply for a Driver's License");
                } else {
                    streamWriter.println();
                    streamWriter.println(name + ", you are still to young to apply for a Driver's License");
                }

                while (true) {
                    try {
                        streamWriter.println();;
                        streamWriter.println("Search another entry [y/n]? ");
                        char charInput = streamReader.readLine().charAt(0);

                        if (charInput != 'y' && charInput != 'n') {
                            streamWriter.println();
                            streamWriter.println("-----------------------------------------------");
                            streamWriter.println("Error: Please select only from characters [y/n]");
                            streamWriter.println("-----------------------------------------------");
                            streamWriter.println();
                        }

                        if (charInput == 'y') {
                            break;
                        }

                         if (charInput == 'n') {
                            serverSocket.close();
                            streamWriter.println();
                            streamWriter.println("--------------------------------------------");
                            streamWriter.println("      Thank you for using the program");
                            streamWriter.println("--------------------------------------------");
                            streamWriter.println();
                            return;
                        }

                    } catch (Exception e) {
                        streamWriter.println();
                        streamWriter.println("----------------------------------------------------------------");
                        streamWriter.println("Error: Not a character. Please select only from characters [y/n]");
                        streamWriter.println("----------------------------------------------------------------");
                        streamWriter.println();
                    }
                }
                
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
