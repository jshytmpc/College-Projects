import java.util.Scanner;

import static com.sun.java.accessibility.util.EventID.ITEM;


/**
 * Write a menu-driven program that provides three options:
 * + Allows the user to enter a temperature in Celsius and displays the corresponding Fahrenheit temperature;
 * + Allows the user to enter a temperature in Fahrenheit and displays the corresponding Celsius temperature;
 * + Allows the user to quit.
 *
 * @author <TIMPAC, JOSHUA C.> <12/23/20>
 */


public class TemperatureConversion {
    Scanner keyboard = new Scanner(System.in);

    public static void showIntroduction() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("        TEMPERATURE CONVERTER (CELSIUS & FAHRENHEIT)       ");
        System.out.println("-----------------------------------------------------------");
        System.out.println("This program converts celsius to fahrengeit and vise versa.");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
    }

    public double tempCelsius() {
        double temp; // temperature

        // System.out.println a "clear instruction that tells the user to input
        // a temperature in celsius" based on your answer in ITEM #2-A
        System.out.println("Enter a temperature in degrees Celsius: ");
        
        temp = keyboard.nextDouble();

        while (temp < -273.15) {
            System.out.println("Error: Temperatures below zero is not applicable");
            temp = keyboard.nextDouble();
        }
        return temp;
    }

    public double tempFahrenheit() {
        double temp; // temperature

        // System.out.println a "clear instruction that tells the user to input
        // a temperature in fahrenheit" based on your answer in ITEM #2-B
        System.out.println("Enter a temperature in degrees Fahrenheit: ");
        temp = keyboard.nextDouble();

        while (temp < -459.67) {
            System.out.println("Error: Temperatures below zero is not applicable.");
            temp = keyboard.nextDouble();
        }
        return temp;
    }

    public void run() {
        double C;
        double F;

        char options;

        do {
            // System.out.println the entire text in ITEM #1
            System.out.println("Enter C to convert Celsius to Fahrenheit.");
            System.out.println("Enter F to convert Fahrenheit to Celsius.");
            System.out.println("Enter Q to exit.");
            

            Scanner keyboard = new Scanner(System.in);
            String a = keyboard.next();
            options = a.charAt(0);

            if ( options == 'C' ) { // user chose to convert celsius to fahrenheit
                C = tempCelsius();

                C = C * 9;
                C = C / 5;
                C = C + 32;

                System.out.println("The temperature is" + C + "degrees Fahrenheit");

            } else if ( options == 'F' ){ // user chose to convert fahrenheit to celsius
                F = tempFahrenheit();

                F = F - 32;
                F = F * 5;
                F = F / 9;

                System.out.println("The temperature is" + F + "degrees Celsius");

            } else if ( options == 'Q') { // user chose to quit
                // System.out.println the last of dialog in ITEM #2-C as a
                // "clear indication that the program [will be] terminated"
                System.out.println("Thank you Godbless :D");
            }

        } while ( options != 'Q' );
    }

    public static void main(String[] args) {
        showIntroduction();
        TemperatureConversion myProgram = new TemperatureConversion();
        myProgram.run();
        
    }
}
