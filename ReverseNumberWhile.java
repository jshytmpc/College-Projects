import java.util.Scanner;
class ReverseNumberWhile
{
   public static void main(String args[])
   {
      int num=0;
      int reversenum =0;
      int sum =0;
      int a =0;
      System.out.println("Input your number and press enter: ");
      //This statement will capture the user input
      Scanner in = new Scanner(System.in);
      //Captured input would be stored in number num
      num = in.nextInt();
      //While Loop: Logic to find out the reverse number
      do{
        a = num %  10;
        reversenum = reversenum * 10 + a;
        sum = sum + a;
        num = num / 10;
      }
        while( num > 0);

        System.out.println("Reverse:"+reversenum);
        System.out.println("Sum of digits:"+sum);

        in.close();
    }
}