package MSPowerPoint;


import java.util.Scanner;

public class TesterDLL {
    public static void main(String[] args) {
        MyDoublyLinkedList dll = new MyDoublyLinkedList<>();
        Scanner kb = new Scanner(System.in);

        dll.showIntroduction();
        dll.showMenu();

        int myChoice;
        do {
            myChoice = enterChoice(1, 7);
            switch (myChoice) {
                case 1 -> dll.createSlides();
                case 2 -> {
                    System.out.println("Insert After slide index: ");
                    int index;
                    try {
                        index = Integer.parseInt(kb.nextLine());
                        dll.insertAfterIndex(index);
                    }catch (Exception e){
                        System.out.println("Invalid input.");
                    }
                }
                case 3 -> {
                    System.out.println("Insert Before slide index: ");
                    int index;
                    try {
                        index = Integer.parseInt(kb.nextLine());
                        dll.insertBeforeIndex(index);
                    }catch (Exception e){
                        System.out.println("Invalid input.");
                    }
                }
                case 4 -> dll.readAllSlides();
                case 5 -> {
                    dll.readAllSlides();
                    System.out.println("Slide index you want to edit (0) - FirstSlide (Size/0-N) - LastSlide: ");
                    int index;
                    try {
                        index = Integer.parseInt(kb.nextLine());
                        dll.updateSlide(index);
                    }catch (Exception e){
                        System.out.println("Invalid input.");
                    }}

                case 6 -> {
                    System.out.println("Slide index you want to delete (0 - First slide) (Size/(0-N) - Last slide): ");
                    int index;
                    try {
                        index = Integer.parseInt(kb.nextLine());
                        dll.deleteSlide(index);
                    }catch (Exception e){
                        System.out.println("Invalid input.");
                    }
                }
            }
        } while (myChoice != 7);
        System.out.println("Thank you for using our bootleg powerpoint");
    }

    public static int enterChoice(int min, int max) {
        Scanner keyboard = new Scanner(System.in);
        MyDoublyLinkedList dll2 = new MyDoublyLinkedList<>();
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
            dll2.showMenu();
        }
        return choice;
    }
}
