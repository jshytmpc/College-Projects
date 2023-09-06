import java.util.Scanner;

public class Rectangle {
    int P, A;
    int l, w;


    public void input() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input l:");
        l = keyboard.nextInt();

        System.out.println("Input w:");
        w = keyboard.nextInt();

        keyboard.close();

    }

    public void process() {

    // INSTRUCTIONS: compute for P and A

        P = (2 * l) + (2 * w);
        A = l * w;
    }

    public void output() {
        System.out.println("P is" + P);
        System.out.println("A is " + A);
    }

    public void run() {
        input();
        process();
        output();
    }

    public static void main(String[] args) {
        Rectangle myProgram = new Rectangle();
        myProgram.run();
    }
}