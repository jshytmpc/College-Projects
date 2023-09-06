import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends CRUDFunctions {
    public static void main(String[] args) {
        menu();
    }

    private static Scanner kb = new Scanner(System.in);

    private static void menu() {
        int choice;
        do{
            displayMenu();
            choice = enterChoice(1,5);
            switch (choice) {
                case 1 -> chooseTerm();
                case 2 -> termGrades();
                case 3 -> enterGrade();
                case 4 -> updateCourse();
            }
        }while(choice != 5);
        System.out.println("Thank you for using the program!");
    }


    private static int enterChoice(int min, int max) {
        int choice = 0;
        while(choice < min || choice > max) {
            try {
                System.out.println();
                System.out.println("Enter your choice:");
                choice = Integer.parseInt(kb.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Error: You must enter only a number from " + min + " to " + max);
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Error: Please enter only numbers");
            }
        }
        return choice;
    }

    private static void displayMenu() {
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                   Main Menu                      |");
        System.out.println("+--------------------------------------------------|");
        System.out.println("1. Show subjects for each school term.             |");
        System.out.println("2. Show subjects with grades for each term.        |");
        System.out.println("3. Enter grades for subjects recently finished.    |");
        System.out.println("4. Edit a course.                                  |");
        System.out.println("5. Quit                                            |");
        System.out.println("+--------------------------------------------------+");
    }
}