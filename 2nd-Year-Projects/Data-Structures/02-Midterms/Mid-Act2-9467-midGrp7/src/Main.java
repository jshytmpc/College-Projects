import java.util.Scanner;

public class Main extends Huffman {
    public static void main(String[] args) {
        Huffman op = new Huffman();
        Scanner sc = new Scanner(System.in);
        int check = 0;
        int option;

        op.intro();

        if (check == 0) {
            op.HuffmanCode();
            op.percentageStorage();
        }
         do {
             op.menu();
            option = enterChoice(1, 4);
            switch (option) {
                case 1 -> {
                    op.HuffmanCode();
                    op.percentageStorage();
                    check++;
                }

                case 2 -> {
                    System.out.println("Input text to be converted: ");
                    String text2 = sc.next();
                        op.txtToHuffman(text2);
                }
                case 3 -> {
                    System.out.println("Input Code to be converted: ");
                    String text = sc.next();
                    if (filter(text)) {
                        op.HuffmanToTxt(text);
                        break;
                    }
                    System.out.println("Error: Please enter only 1s and 0s");
                }
            }
        } while (option != 4);
        System.out.println("Thank you for using our code");

    }
    public static int enterChoice(int min, int max) {
        Scanner keyboard = new Scanner(System.in);
        Huffman op = new Huffman();
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
            op.menu();
        }
        return choice;
    }

    public static boolean filter(String text) {
        for (int i = 0; i <text.length();i ++){
            String c = String.valueOf(text.charAt(i));
            if (!c.matches("[01]+")){
                return false;
            }
        }
        return true;
    }
}
