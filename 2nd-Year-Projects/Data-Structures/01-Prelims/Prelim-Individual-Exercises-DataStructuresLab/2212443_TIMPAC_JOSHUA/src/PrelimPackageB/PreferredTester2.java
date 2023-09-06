package PrelimPackageB;



import java.util.Scanner;


public class PreferredTester2 extends MyGrowingArrayList {


    public static void main(String[] arg) throws ListOverflowException {

        PreferredTester2 Function = new PreferredTester2();


        int myChoice;


        Function.showMenu();
        System.out.println("");


        do {
            myChoice = enterChoice(1, 10);
            switch (myChoice) {

                    case 1 -> Function.showMenu();
                    case 2 -> Function.addElement();
                    case 3 -> Function.grow();
                    case 4 -> Function.getSize();
                    case 5 -> System.out.println(Function.listJoshua);
                    case 6 -> Function.insert(Function.listJoshua);
                    case 7 -> Function.getElement(Function.listJoshua);
                    case 8 -> Function.delete(Function.listJoshua);
                    case 9 -> Function.search(Function.listJoshua);
            }


        } while (myChoice != 10);
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


