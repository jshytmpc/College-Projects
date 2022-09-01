import java.util.Scanner;

public class MetersToCentimeters {
    int meters;
    int centimeters;

    public void inputLengthInMeters() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a length in meters: ");
        meters = keyboard.nextInt();
        keyboard.close();
    }

    public void processMetersToCentimeters() {
        centimeters = meters * 100;
    }

    public void outputLengthInCentimeters() {
        System.out.println("The length is equal to " + centimeters + " cm.");
    }

    public void run() {
        inputLengthInMeters();
        processMetersToCentimeters();
        outputLengthInCentimeters();
    }

    public static void main(String[] args) {
        MetersToCentimeters myProgram = new MetersToCentimeters();
        myProgram.run();
    }
}