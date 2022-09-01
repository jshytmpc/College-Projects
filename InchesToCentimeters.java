import java.util.Scanner;

public class InchesToCentimeters {
    int inches;
    double centimeters;

    public void inputLengthInInches() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a length in inches");
        inches = keyboard.nextInt();
        keyboard.close();
    }

    public void convertToCentimeters() {
        centimeters = inches * 2.54;
    }

    public void displayConvertedLength() {
        System.out.println("That length is equal to " + centimeters + " cm.");
    }

    public void run() {
        inputLengthInInches();
        convertToCentimeters();
        displayConvertedLength();
    }

    public static void main(String[] args) {
        InchesToCentimeters myProgram = new InchesToCentimeters();
        myProgram.run();
    }
}