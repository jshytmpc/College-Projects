package pregroup01;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FractionArithmetic extends Fraction {

    public static void main(String[] args) {
        introduction();
        showMenu();
    }

    private static void showMenu() {
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction();
        boolean check = false;


        int myChoice;
        do {
            if(!check) {
                frac1 = enterFraction("Fraction 1");
                System.out.println("Fraction 1 is " + frac1 + " or in decimal form is " + frac1.toDouble());
                System.out.println();
                frac2 = enterFraction("Fraction 2");
                System.out.println("Fraction 2: " + frac2 + " or " + frac2.toDouble());
                System.out.println();
            }

            menu();
            myChoice = enterChoice(1, 8);
            switch (myChoice) {
                case 1 -> {
                    frac1 = enterFraction("Fraction 1");
                    System.out.println("Fraction 1 is " + frac1 + " or in decimal form is " + frac1.toDouble());
                    System.out.println();
                }
                case 2 -> {
                    frac2 = enterFraction("Fraction 2");
                    System.out.println("Fraction 2: " + frac2 + " or " + frac2.toDouble());
                    System.out.println();
                }
                case 3 -> {
                    Fraction sum = frac1.add(frac2);
                    System.out.println(frac1 + " + " + frac2 + " = " + sum.toString() + " or " + sum.toDouble());
                }
                case 4 -> {
                    Fraction diff = frac1.subtract(frac2);
                    System.out.println(frac1 + " - " + frac2 + " = " + diff.toString() + " or " + diff.toDouble());
                }
                case 5 -> {
                    Fraction prod = frac1.multiply(frac2);
                    System.out.println(frac1 + " * " + frac2 + " = " + prod.toString() + " or " + prod.toDouble());
                }
                case 6 -> {
                    Fraction quot = frac1.divide(frac2);
                    System.out.println(frac1 + " + " + frac2 + " = " + quot.toString() + " or " + quot.toDouble());
                }
                case 7 -> {
                    reduceMenu();
                    int c = enterChoice(1,2);
                    if (c == 1) {
                        frac1.reduce();
                        System.out.println("Simplified: " + frac1 + " or " + frac1.toDouble());
                        break;
                    }
                    if (c == 2) {
                        frac2.reduce();
                        System.out.println("Simplified: " + frac2 + " or " + frac2.toDouble());
                    }
                }
            }
            check = true;
        } while (myChoice != 8);
        System.out.println("Thank you for using our program");
    }

    /**
     * Shows the list of options for the menu.
     */

    private static void menu() {
        System.out.println();
        System.out.println("+-----------------------------------------+");
        System.out.println("|   1. Enter/update value of fraction 1   |");
        System.out.println("|   2. Enter/update value of fraction 2   |");
        System.out.println("|   3. Add Fractions                      |");
        System.out.println("|   4. Subtract Fractions                 |");
        System.out.println("|   5. Multiply Fractions                 |");
        System.out.println("|   6. Divide Fractions                   |");
        System.out.println("|   7. Reduce Fractions                   |");
        System.out.println("|   8. Exit                               |");
        System.out.println("+-----------------------------------------+");
    }

    private static void reduceMenu() {
        System.out.println("+----------------------------------+");
        System.out.println("|   1. Reduce fraction 1           |");
        System.out.println("|   2. Reduce fraction 2           |");
        System.out.println("+----------------------------------+");
    }

    /**
     * Shows the list of the program name and its programmers.
     */

    private static void introduction() {
        System.out.println();
        System.out.println("+----------------------------------+");
        System.out.println("|        FRACTION CALCULATOR       |");
        System.out.println("+----------------------------------+");
        System.out.println("|           programmed by:         |");
        System.out.println("|          Timpac, Joshua          |");
        System.out.println("|            Gorio, Ian            |");
        System.out.println("|       Berlanga, Erycknielzon     |");
        System.out.println("|           Noveda, Leztat         |");
        System.out.println("+----------------------------------+");
    }


    /**
     * EnterChoice Method - A try catch method that checks the choices if it is within the range.
     * @param min - This value is the minimum number choice for the menu.
     * @param max - This value is the maximum number choice for the menu.
     * @return - This returns the integer choice.
     */

    private static int enterChoice(int min, int max) {
        Scanner keyboard1 = new Scanner(System.in);
        int choice = 0;

        try {
            System.out.println();
            System.out.println("Enter Option:");
            choice = keyboard1.nextInt();
            if(choice < min || choice > max) {
                System.out.println("Error: Select only from numbers " + min + " and " + max);
                return choice;
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid Input. Please Enter Numbers Only.");
        }
        return (choice);
    }

    /**
     * Enter Fraction Method
     * @param operand indicates the if its fraction 1 or fraction 2
     * @return returns Fraction that has been inputted after checking it for errors
     */
    
    private static Fraction enterFraction(String operand) {
        Fraction fraction;
            int numerator, denominator;
            numerator = enterFractionData("numerator", operand);
            denominator = enterFractionData("denominator", operand);
            if (denominator == 1) {
                fraction = new Fraction(numerator); // wholeNumber
                return fraction;
            }
            fraction = new Fraction(numerator, denominator);
        return fraction;
    }


    /**
     *
     * @param part - this is determines the part of the fraction. The first input is the numerator and the second input is the denominator.
     * @param fractionInfo - this determines the operand number of the fraction weather it is one or two.
     * @return input - brings back the input as the value for the part of the fraction whether it's a numerator or a denominator.
     */

    private static int enterFractionData(String part, String fractionInfo) {
        Scanner kb = new Scanner(System.in);
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
        }
        return num;
    }

}
