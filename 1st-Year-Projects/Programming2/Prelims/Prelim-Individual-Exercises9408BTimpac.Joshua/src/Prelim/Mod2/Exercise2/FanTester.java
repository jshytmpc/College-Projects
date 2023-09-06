package Prelim.Mod2.Exercise2;


import java.util.ArrayList;
import java.util.Scanner;

public class FanTester {
    static Scanner kb = new Scanner(System.in);
    static ArrayList<Fan> fans = new ArrayList<>();
    static Fan fan = new Fan();
    public static void main(String[] args) {
        /*
          DEFAULT FAN
         */
        System.out.println();
        System.out.println("Default FAN");
        System.out.println();
        fan.print();


        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println();


        /*
          USING CONSTRUCTOR 1
         */
        System.out.println("CONSTRUCTOR 1");
        System.out.println();
        Fan fan1 = new Fan();
        System.out.println("1ST FAN");
        fan1.setSpeed(1);
        fan1.printSpeed(1);
        fan1.setOn(true);
        fan1.setRadius(12);
        fan1.setColor("Orange");
        System.out.println(fan1);

        System.out.println();

        Fan fan2 = new Fan();
        System.out.println("2nd FAN");
        fan2.setSpeed(3);
        fan2.printSpeed(3);
        fan2.setOn(false);
        fan2.setRadius(6);
        fan2.setColor("Green");
        System.out.println(fan2);

        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println();

        /*
          USING CONSTRUCTOR 2
         */

        System.out.println("CONSTRUCTOR 2");
        System.out.println();
        Fan fans1 = new Fan(1,true,12,"orange");
        System.out.println("1st FAN");
        System.out.println(fans1);
        System.out.println();
        Fan fans2 = new Fan(3,false,6,"green");
        System.out.println("2nd FAN");
        System.out.println(fans2);
        System.out.println();

        for(int i = 0; i < 4;i++) {
            System.out.println();
            System.out.println("CREATE NEW FAN");
            System.out.println();
            System.out.println("Enter a fan speed: ");
            int s = kb.nextInt();
            System.out.println();
            System.out.println("Enter fan switch: ");
            System.out.println("Type true for On and false for Off");

            boolean b = kb.nextBoolean();
            System.out.println("Enter the fan radius: ");
            double d = kb.nextDouble();
            System.out.println();
            System.out.println("Enter the fan color: ");
            String c = kb.next();
            fans.add(new Fan(s,b,d,c));
            System.out.println();
            System.out.println("FANS CREATED");
            System.out.println(fans);
        }
    }
}
