import java.util.Scanner;

public class FootToInches {
    int foot;
    int inches;

    public void inputLengthInFeet() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a length in feet: ");
        foot = keyboard.nextInt();
        keyboard.close();
    }

    public void processFootToInches() {
        inches = foot * 12;
    }

    public void outputLengthInInches() {
        System.out.println("The length is equal to " + inches + " in.");
    }

    public void run() {
        inputLengthInFeet();
        processFootToInches();
        outputLengthInInches();
    }

    public static void main(String[] args) {
        FootToInches myProgram = new FootToInches();
        myProgram.run();
    }
}