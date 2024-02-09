package pexer3;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Parser
 */
public class Parser {

  public static void main(String[] args) {
    try {
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

      // Print xml
      printExpressions(expressions);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void printExpressions(NodeList node) {
    String dash = "-";
    System.out.println("|" + dash.repeat(69) + "|");
    System.out.printf("%15s %15s %15s %15s \n", "Operand1", "Operator", "Operand2", "Result");
    System.out.println("|" + dash.repeat(69) + "|");
    for (int i = 0; i < node.getLength(); i++) {
      Node expression = node.item(i);
      // Check if node is an element type
      if (expression.getNodeType() == Node.ELEMENT_NODE) {
        Element expElement = (Element) expression;
        System.out.printf("%15s %15s %15s %15s \n", 
        expElement.getElementsByTagName("operand1").item(0).getTextContent(), 
        expElement.getElementsByTagName("operator").item(0).getTextContent(), 
        expElement.getElementsByTagName("operand2").item(0).getTextContent(), 
        "Result");
      }
    }
    System.out.println("|" + dash.repeat(69) + "|");
  }
}
