import java.util.Scanner;

public class numFactorial {
    public static void main(String[] args) {

        int num, fac = 1, x = 1;


        System.out.println ("Input your number and press enter: ");
        Scanner keyboard = new Scanner(System.in);
        num = keyboard.nextInt();     

                if(num <= 0)
                        System.out.println ("Error: Please input a positive number");
                        
                else{
                        while(x <= num ){
                            fac = fac * x;
                            x = x + 1;
                        }
                    System.out.println ("The Factorial of " +num+ " is " + fac);
                }
                keyboard.close();
                
    }
}