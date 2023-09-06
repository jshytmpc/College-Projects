package Prelim.Mod1;

import java.util.Scanner;

public class RecursionTest {

    public int factorial(int number) {
        if (number <= 1) { // base case
            return 1;
        } else { // recursive step
            return number * factorial(number - 1);
        }
    } // end method factorial


    public int fibonacci(int n) {
        if (n == 0 || n == 1) { // base cases
            return n;

        } else { // recursive step
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public void run() {
        Scanner keyboard = new Scanner(System.in);
        int n;

        System.out.println("Getting the factorial of a number");
        System.out.print("Enter a number: ");
        n = keyboard.nextInt();
        System.out.print("The factorial of "+ n +" is: " + factorial(n));

        System.out.println();
        System.out.println();

        System.out.println("Getting the nth of the Fibonacci Sequence");
        System.out.print("Enter a nth term: ");
        n = keyboard.nextInt();
        for(int i = 0; i <= n; i++){
            System.out.print(fibonacci(i) +" ");
        }
        System.out.println();
        System.out.println();
        System.out.print("The "+ n +"th " + "Fibonacci number is: " + fibonacci(n));
        }

    public static void main(String[] args) {
        RecursionTest myProgram = new RecursionTest();
        myProgram.run();
    }
}
