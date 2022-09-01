import java.util.Scanner;

public class Triangle {
    int P, A;
    int a, b, c, h;


    public void input() {

        //INSTRUCTIONS: Input a, b, c, and h

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input side (a): ");
        a = keyboard.nextInt();

        System.out.println("Input side (b): ");
        b = keyboard.nextInt();

        System.out.println("Input side (c): ");
        c = keyboard.nextInt();
        
        System.out.println("Input the height (h): ");
        h = keyboard.nextInt();
        
        keyboard.close();
    }

    public void process() {
        P = a + b + c;
        A = (b * h) / 2;
    }

    public void output() {
        System.out.println("P is " + P);
        System.out.println("A is " + A);
    }

    public void run() {
        input();
        process();
        output();
    }

    public static void main(String[] args) {
        Triangle myProgram = new Triangle();
        myProgram.run();
    }
    
}
