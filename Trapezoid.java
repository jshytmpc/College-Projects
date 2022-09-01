import java.util.Scanner;

public class Trapezoid {
    int P, A;
    int a, b, c, d, h;


    public void input() {

        // INSTRUCTIONS: Input a, b, c, d, and h

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input side (a): ");
        a = keyboard.nextInt();

        System.out.println("Input side (b): ");
        b = keyboard.nextInt();

        System.out.println("Input side (c): ");
        c = keyboard.nextInt();

        System.out.println("Input side (d): ");
        d = keyboard.nextInt();
        
        System.out.println("Input the height (h): ");
        h = keyboard.nextInt();
        
        keyboard.close();
    }

    public void process() {
        
        // INSTRUCTIONS: Compute for P and A

        P = a + b + c + d;
        A = h * (a + b) / 2;
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
        Trapezoid myProgram = new Trapezoid();
        myProgram.run();
    }
}