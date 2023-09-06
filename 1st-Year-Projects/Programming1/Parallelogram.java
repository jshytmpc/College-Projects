import java.util.Scanner;

public class Parallelogram {
    int P, A;
    int a, b, h;


    public void input() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input a:");
        a = keyboard.nextInt();

        System.out.println("Input b:");
        b = keyboard.nextInt();

        System.out.println("Input h:");
        h = keyboard.nextInt();

        keyboard.close();
    }

    public void process() {
        P = 2 * a + 2 * b;
        A = b * h;
    }

    public void output() {

        // INSTRUCTIONS: Output P and A

        System.out.println("P is " + P);
        System.out.println("A is " + A);
    }

    public void run() {
        input();
        process();
        output();
    }

    public static void main(String[] args) {
        Parallelogram myProgram = new Parallelogram();
        myProgram.run();
    }
}