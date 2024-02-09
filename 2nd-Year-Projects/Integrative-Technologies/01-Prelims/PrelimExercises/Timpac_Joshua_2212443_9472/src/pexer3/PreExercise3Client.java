package pexer3;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * PreExercise3Client
 */
public class PreExercise3Client {

  public static void main(String[] args) {
    int port = 3000;
    try (
      // Instantiate client socket, reader, and writer
      Scanner keyboard = new Scanner(System.in);
      Socket socket = new Socket("localhost", port);
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );
      PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
    ) {
      // Instantiate necessary intefaces
      File filePath = new File(
        "PrelimExercises\\Timpac_Joshua_2212443_9472\\res\\exer3.xml"
      );
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = factory.newDocumentBuilder();

      // Get Document
      Document document = documentBuilder.parse(filePath);

      // Normalize the xml structure
      document.getDocumentElement().normalize();

      // Parse xml to nodelist
      NodeList expressions = document.getElementsByTagName("expression");

      // Send input to server
      for (int i = 0; i < expressions.getLength(); i++) {
        Node expression = expressions.item(i);
        // Check if node is an element type
        if (expression.getNodeType() == Node.ELEMENT_NODE) {
          Element expElement = (Element) expression;
          writer.println(expElement.getElementsByTagName("operand1").item(0).getTextContent());
          writer.println(expElement.getElementsByTagName("operator").item(0).getTextContent());
          writer.println(expElement.getElementsByTagName("operand2").item(0).getTextContent());
          System.out.println(reader.readLine());
        }
      }
      // Print the server response
      System.out.println(reader.readLine());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
