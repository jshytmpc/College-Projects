import java.util.Scanner;

/**
 * Design and implement a program that converts a sum of money to US Dollars.
 * The amount of money to be converted, and the exchange rate, are entered by the user.
 *
 * The program should have separate methods for:
 * + obtaining the sum of money from the user;
 * + obtaining the exchange rate from the user;
 * + making the conversion;
 * + displaying the result.
 *
 * @author <TIMPAC, JOSHUA, C.> <12/24/2020>
 */
public class ForeignExchange {
    Scanner keyboard = new Scanner(System.in);

    public double obtainSumOfMoney() {
        System.out.println("Enter amount of money in the local currency:");
        return keyboard.nextDouble();
    }

    public double obtainExchangeRate() {
        System.out.println("Enter exchange rate of the local currency to 1 USD:");
        return keyboard.nextDouble();
    }

    public double convertToUSD(double amountLocalCurrency, double rate) {
        return amountLocalCurrency / rate;
    }

    public void displayResult(double  amountUSDollar) {
        System.out.println("That is equivalent to " + amountUSDollar +  " USD.");
    }

    public void run() {
        double amountLocalCurrency;
        double amountUSDollar;
        double rate;

        // Convert a given amount in local currency to US dollars
        
        // INPUT: Invoke the methods to input values for amountLocalCurrency and rate
        amountLocalCurrency = obtainSumOfMoney();
        rate = obtainExchangeRate();

        // PROCESS: Invoke the methods to convert amountLocalCurrency to amountUSDollar
        amountUSDollar = convertToUSD(amountLocalCurrency, rate);
        
        // OUTPUT: Invoke the methods to display amountUSDollar
        displayResult(amountUSDollar);
    }

    public static void main(String[] args) {
        // provide the missing code here to invoke the run method
        ForeignExchange myProgram = new ForeignExchange();
        myProgram.run();
    }
}
