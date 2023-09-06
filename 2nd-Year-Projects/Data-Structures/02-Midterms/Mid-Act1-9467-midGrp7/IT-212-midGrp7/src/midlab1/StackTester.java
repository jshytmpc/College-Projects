package midlab1;

import java.util.Scanner;

public class StackTester extends InfixToPostfix {
    public static void main(String[] args) {
        //     String exp = "1+2*(3^2+1)";
        Scanner sc = new Scanner(System.in);
        intro();
        menu();
        int myChoice;
        do {
            myChoice = enterChoice(1, 3);
            switch (myChoice) {
                case 1:
                    System.out.println("Enter Infix Expression: ");
                    String exp = sc.nextLine();
                    exp = exp.replaceAll("\\s", "");

                    if (exp.isEmpty()) {
                        System.out.println("No expression entered");
                        System.out.println();
                        break;
                    }

                    if (filter(exp)) {
                        infixToPostfix(exp);
                        break;
                    }
                    break;

                case 2:
                    System.out.println("Enter Postfix Expression: ");
                    exp = sc.nextLine();
                    exp = exp.replaceAll("\\s", "");

                    if (exp.isEmpty()) {
                        System.out.println("No expression entered");
                        System.out.println();
                        break;
                    }
                    if (filter(exp)) {
                        System.out.println(evaluatePostfix(exp) + "\n");
                        break;
                    }
                    System.out.println("Error: No Special Characters allowed");
                    break;
            }
        } while (myChoice != 3);
    }

    public static int enterChoice(int min, int max) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;

        try {
            do {
                System.out.println();
                System.out.println("Option:");
                choice = keyboard.nextInt();
                if (choice < min || choice > max)
                    System.out.println("Invalid Choice please only enter a number from " + min + " to " + max);

            } while (choice < min || choice > max);
            return (choice);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        return choice;
    }

    public static void menu() {
        System.out.println("1 - Infix to Postfix (no spaces between characters)");
        System.out.println("2 - Postfix Evaluation (no spaces between characters, operands must be numbers)");
        System.out.println("3 - Exit");
    }

    public static void intro() {
        System.out.println("Infix to Postfix Program");
        System.out.println("by: Arnobit, Gorio, Mayangao, Timpac");
        System.out.println();
    }

    public static boolean filter(String exp) {
        for (int i = 0; i <exp.length();i ++){
            String c = String.valueOf(exp.charAt(i));
            if (!c.matches("[A-Za-z0-9+*/^(-){-}-]+")){
                System.out.println("Error: No Special Characters allowed");
                System.out.println();
                return false;
            }
        }
        return true;
    }

}
