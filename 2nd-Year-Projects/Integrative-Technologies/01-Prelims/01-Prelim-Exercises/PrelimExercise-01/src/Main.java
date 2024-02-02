import java.util.Scanner;

public class Main extends Functions {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        showIntroduction();

        // Initialized variables
        char choice;
        int count = 1;


        // Print all hostname IP addresses
        getHostAddresses(count);
        do {
            System.out.print("Search another [y/n]? ");
            char charInput = keyboard.nextLine().charAt(0);
            choice = charInput;

            if(charInput != 'y' && charInput != 'n') {
                System.out.println();
                System.out.println("-----------------------------------------------");
                System.out.println("                  ( ͡❛ 益 ͡❛)👎");
                System.out.println("Error: Please select only from characters [y/n]");
                System.out.println("-----------------------------------------------");

                System.out.println();
            }

            if (choice == 'y') {
                count++;
                getHostAddresses(count);
            }

        } while (choice != 'n');
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("                 👍( ͡❛ 益 ͡❛👍)");
        System.out.println("      Thank you for using the program");
        System.out.println("--------------------------------------------");
        System.out.println();
        keyboard.close();
    } 

    private static void getHostAddresses(int count) {
            System.out.println();
            System.out.print("Host " + count + " - Type IP address/Hostname: ");
            String hostname = keyboard.nextLine();
            getAllIps(hostname);
            System.out.println();
    }
}
