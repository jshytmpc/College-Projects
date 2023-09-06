package PrelimPackageA;



import java.util.Scanner;


public class PreferredTester extends MyFixedArrayList {


    public static void main(String[] arg) throws ListOverflowException {

        PreferredTester Function = new PreferredTester();

        int myChoice;

        Function.showMenu();
        System.out.println("");

        do {
            myChoice = enterChoice(1, 9);
            switch (myChoice) {
                case 1 -> {Function.showMenu();}
                case 2 -> {
                    Function.getSize();
                    System.out.println("");
                }
                case 3 -> System.out.println(Function.listJoshua);
                case 4 -> Function.addElement();
                case 5 -> Function.search(Function.listJoshua);
                case 6 -> Function.delete(Function.listJoshua);
                case 7 -> Function.insert(Function.listJoshua);
                case 8 -> Function.getElement(Function.listJoshua);
            }


        } while (myChoice != 9);
        System.out.println("Thank you for using my program. I hope you enjoyed"); ;
    }

    public static int enterChoice(int min, int max){
        Scanner keyboard = new Scanner(System.in);
        int choice;
        do{

            System.out.println("Please enter a number of your choice:");

            choice = keyboard.nextInt();
            if(choice<min || choice > max)
                System.out.println("Invalid Choice please only enter a number from " + min + " to " + max);
        }while (choice < min || choice > max);
        return (choice);
    }


    }


