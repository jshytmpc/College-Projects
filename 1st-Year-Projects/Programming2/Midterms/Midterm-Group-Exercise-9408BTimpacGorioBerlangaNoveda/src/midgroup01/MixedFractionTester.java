package midgroup01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MixedFractionTester {
    static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        Fraction operand1 = null, operand2 = null;
        showIntroduction();
        showMainMenu(operand1, operand2);
    }

    private static void showMainMenu(Fraction f1, Fraction f2) {
        Scanner input = new Scanner(System.in);
        int choice;
        MixedFraction   mixedFrac1 = new MixedFraction();
        MixedFraction   mixedFrac2 = new MixedFraction();
        String a = "",
                b = "";

        do {
            mainMenu();
            choice = intChoice(1, 8);
            switch (choice) {
                case 1 -> {
                        System.out.println("-----Fraction 1-----");
                        f1 = enterFraction("Fraction 1");
                        mixedFrac1 = (MixedFraction) f1;
                        a = mixedFrac1.toString();
                }
                case 2 -> {
                    System.out.println("-----Fraction 2------");
                    f2 = enterFraction("Fraction 2");
                    mixedFrac2 = (MixedFraction) f2;
                    b = mixedFrac2.toString();
                }
                case 3 -> {
                    if (nullChecker(f1, f2)) {
                        break;
                    }
                    mixedFrac1.toFraction();
                    MixedFraction sum =   mixedFrac1.add(mixedFrac2);
                    sum.reduce();
                    System.out.println(a + " + " + b + " = " + sum + " or in Decimal " + sum.toDouble());
                    System.out.println("\n");
                    System.out.println("Press enter to return to menu...");
                    input.nextLine();
                }
                case 4 -> {
                    if (nullChecker(f1, f2)) {
                        break;
                    }
                    mixedFrac1.toFraction();
                    MixedFraction diff =   mixedFrac1.subtract(mixedFrac2);
                    diff.reduce();
                    System.out.println(a + " - " + b + " = " + diff + " or in Decimal " + diff.toDouble());
                    System.out.println("\n");
                    System.out.println("Press enter to return to menu...");
                    input.nextLine();
                }
                case 5 -> {
                    if (nullChecker(f1, f2)) {
                        break;
                    }
                    mixedFrac1.toFraction();
                    MixedFraction product =   mixedFrac1.multiply(mixedFrac2);
                    product.reduce();
                    System.out.println(a + " * " + b + " = " + product + " or in Decimal " + product.toDouble());
                    System.out.println("\n");
                    System.out.println("Press enter to return to menu...");
                    input.nextLine();
                }
                case 6 -> {
                    if (nullChecker(f1, f2)) {
                        break;
                    }
                        mixedFrac1.toFraction();
                        MixedFraction quotient = mixedFrac1.divide(mixedFrac2);
                        quotient.reduce();
                        System.out.println(a + " / " + b + " = " + quotient + " or in Decimal " + quotient.toDouble());
                        System.out.println("\n");
                        System.out.println("Press enter to return to menu...");
                        input.nextLine();
                }
                case 7 -> {
                    if (nullChecker(f1, f2)) {
                        break;
                    }
                    int c;
                    do {
                        System.out.println("Which Fraction would you like to simplify?  1 or 2 : ");
                        c = input.nextInt();
                        if (c == 1) {
                            f1.reduce();
                            System.out.println("Fraction 1: " + f1);
                        } else if (c == 2) {
                            f2.reduce();
                            System.out.println("Fraction 2: " + f2);
                        } else {
                            System.out.println("Error: Please choose only from 1 and 2");
                            input.nextLine();
                        }
                    } while (c < 1 || c > 2);
                    System.out.println("\n");
                    System.out.println("Press enter to return to menu...");
                    input.nextLine();
                }
                case 8 -> {
                    System.out.println("\n");
                    System.out.println("Thank you for using this Program.");
                }
            }
        }
        while (choice != 8) ;
    }

    public static boolean nullChecker(Fraction f1, Fraction f2) {
        if (f1 == null || f2 == null) {
            System.out.println("Error: No value. Enter values for the 2 Fractions");
            System.out.println("\n");
            return true;
        }
        return false;
    }

    // Prints the Menu
    public static void mainMenu() {
        System.out.println("+---------------------------------------------------+");
        System.out.println("|                      Main Menu                    |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("|    1. Enter or Change the value of fraction 1     |");
        System.out.println("|    2. Enter or Change the value of fraction 2     |");
        System.out.println("|    3. Add the Fractions (+)                       |");
        System.out.println("|    4. Subtract the Fractions (-)                  |");
        System.out.println("|    5. Multiply the Fractions (*)                  |");
        System.out.println("|    6. Divide the Fractions (/)                    |");
        System.out.println("|    7. Simplify Fraction                           |");
        System.out.println("|    8. Quit                                        |");
        System.out.println("+---------------------------------------------------+");

    }
    // Prints the introduction and information about the program
    private static void showIntroduction() {
        System.out.println();
        System.out.println("+----------------------------------+");
        System.out.println("|    MIXED FRACTION CALCULATOR     |");
        System.out.println("+----------------------------------+");
        System.out.println("|           programmed by:         |");
        System.out.println("|          Timpac, Joshua          |");
        System.out.println("|            Gorio, Ian            |");
        System.out.println("|       Berlanga, Erycknielzon     |");
        System.out.println("|           Noveda, Leztat         |");
        System.out.println("+----------------------------------+");
        System.out.println();
    }

    public static int intChoice(int min, int max) {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        try {
            do {
                System.out.println("\n");
                System.out.print("Input the number of your choice: ");
                choice = keyboard.nextInt();
                if (choice < min || choice > max)
                    System.out.println("Error: Invalid Choice. Please choose numbers only from " + min + " to " + max + ".");
            } while (choice < min || choice > max);
            return (choice);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid choice only use numbers from " + min + " to " + max);
        }
        return choice;
    }


    private static Fraction enterFraction(String operand) {
        Fraction fraction = null;
            int numerator, denominator, whole;
            System.out.println("Press enter 0 if there is no whole number value");
            whole = enterFractionData("whole", operand);
            numerator = enterFractionData("numerator", operand);
            denominator = enterFractionData("denominator", operand);
            fraction = new MixedFraction(whole, numerator, denominator);
            return fraction;
    }

    private static int enterFractionData(String part, String fractionInfo) {
        int num = 0;
        String input = "";
        try {
            System.out.print("Enter value of the " + part + " of " + fractionInfo + ": ");
            input = kb.nextLine();
            num = Integer.parseInt(input);
        } catch (NumberFormatException noNumb) {
            System.out.println();
            System.out.println("Error: " + input + " is not a valid number. Please try again.");
            System.out.println();
            return num;
        }
        return num;
    }

}
