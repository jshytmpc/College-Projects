package pexer3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * PreExercise3Server
 */
public class PreExercise3Server {
    public static void main(String[] args) {
        int port = 3000;
        // Parenthesis try catch that implements the AutoClosable interface
        try (
            // Instantiate ServerSocket, Socket for client, and Reader
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            if (clientSocket.isConnected()) {
                System.out.println("Server is running at port " + port);
                System.out.println("Client connected");
            }

            
            // Get input message from client
            for (int i = 0; i < 10; i++) {
                int operand1 = Integer.parseInt(reader.readLine());
                char operator = reader.readLine().charAt(0);
                int operand2 = Integer.parseInt(reader.readLine());
                writer.println(calculator(operand1, operand2, operator));
            }         

            // Message to client on exit
            writer.println();
            writer.println("--------------------------------------------");
            writer.println("      Thank you for using the program");
            writer.println("--------------------------------------------");
            writer.println();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calculator(int operand1, int operand2, char operator) {
            try {
                   switch (operator) {
            case '%' -> {
                return Integer.valueOf(operand1) % Integer.valueOf(operand2);
            }
            case '+' -> {
                return Integer.valueOf(operand1) + Integer.valueOf(operand2);
            }
            case '-' -> {
                return Integer.valueOf(operand1) - Integer.valueOf(operand2);
            }
            case '*' -> {
                return Integer.valueOf(operand1) * Integer.valueOf(operand2);
            }
            case '/' -> {
                return Integer.valueOf(operand1) / Integer.valueOf(operand2);
            }  
            case '^' -> {
                return Integer.valueOf(operand1) ^ Integer.valueOf(operand2);
            }
            default -> {
		        return 0;
            }}
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
     
    }
}