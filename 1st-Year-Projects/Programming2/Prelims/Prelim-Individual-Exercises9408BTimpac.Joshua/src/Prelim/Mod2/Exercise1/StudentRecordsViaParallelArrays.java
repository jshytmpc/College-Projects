/**
 * Name of Student/Programmer: JOSHUA C. TIMPAC
 * CLASS CODE & Schedule: 9408 / 9:00-10:30AM Mon&Thur
 * Date: February 7, 2023,
 * Student Records Keeping Using Parallel Arrays
 * <p>
 * An ID number, a name, a course, a year level and others are
 * attributed to a student. Hence, eight arrays are
 * used: An array that stores ID numbers, an array that
 * stores names, an array that stores courses, an array
 * that stores year levels, etc. The eight arrays are treated
 * as parallel arrays such that the first elements of the
 * eight arrays are actual attributes (ID number, name, course,
 * year level, etc. ) of one student, the second elements are
 * actual attributes of another student, and so on.
 * <p>
 * <p>
 * REQUIRED:
 * Complete and show a sample run (sample output) of the following
 program.
 **/


package Prelim.Mod2.Exercise1;

import java.util.Scanner;

public class StudentRecordsViaParallelArrays {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String[] id; // Array that will store ID numbers
        String[] names; // Array that will store names
        String[] course;// Array that will store courses
        int[] yearLevel; // array that will store year levels
        int count; // variable that will store the number of students
        byte[] pGrade; // to store prelim grade
        byte[] mGrade; // to store midterm grade
        byte[] tFGrade; // to store tentative Final Grade
        byte[] fGrade; // to store final grade

        // Read the number of students to be recorded from the keyboard

        System.out.print("How many student records will be created? ");
        count = Integer.parseInt(keyboard.nextLine());

        // Instantiate the arrays such that each will have a length=size

        id = new String[count];
        names = new String[count];
        course = new String[count];
        yearLevel = new int[count];
        pGrade = new byte[count];
        mGrade = new byte[count];
        tFGrade = new byte[count];
        fGrade = new byte[count];

        //Invoke the method that will fill the arrays with elements
        populateArrays(id, names, course, yearLevel, pGrade, mGrade,
                tFGrade, fGrade);

        // Show the students following the order by which they were entered
        System.out.println("Original Order Data");
        showData(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);
        // Invoke the method for displaying the array elements

        // Invoke the method that will sort the arrays in parallel
        sortDataBasedOnNames(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);
        // Invoke the method for displaying the array elements

        // Show the students in sorted order
        System.out.println("Sorted Data");
        showData(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);
    }

    /**
     * Put elements into arrays (parallel arrays) for ID numbers, names, course, year levels, prelim grade,
     * midterm grade, tentative final grade, and final grade
     **/

    public static void populateArrays(String[] id, String[] n, String[] c, int[] y, byte[] p, byte[] m, byte[] t, byte[] f) {
            for (int index = 0; index < n.length; index++) {

            System.out.print("Enter the id number of student " + (index + 1) + ": ");
            id[index] = keyboard.nextLine();

            System.out.print("Enter the name of student " + (index + 1) + ": ");
            n[index] = keyboard.nextLine();

            System.out.print("Enter the course of student " + (index + 1) + ": ");
            c[index] = keyboard.nextLine();

            System.out.print("Enter the year level of student " + (index + 1) + ": ");
            y[index] = Integer.parseInt(keyboard.nextLine());

            System.out.print("Enter the prelim grade of student " + (index + 1) + ": ");
            p[index] = Byte.parseByte(keyboard.nextLine());

            System.out.print("Enter the midterm grade of student " + (index + 1) + ": ");
            m[index] = Byte.parseByte(keyboard.nextLine());

            System.out.print("Enter the tentative final grade of student " + (index + 1) + ": ");
            t[index] = Byte.parseByte(keyboard.nextLine());

            // compute the final grade of student as the average of prelim, midterm and tentative final grade
            f[index] = (byte) ((1.0 * p[index] + 1.0 * m[index] + 1.0 * t[index]) / 3.0 + 0.5);

        }
        return;
    }

    /**
     * Sort the elements of the eight arrays in parallel (i.e. When
     * there is a need to swap elements of the array n,
     * the corresponding elements in other arrays should also
     * be swapped.) such that the elements of array n
     * are lexicographically arranged. (SPECIFY the Apply a Sort Algorithm
     * that you will follow
     */

    public static void sortDataBasedOnNames(String[] id, String[] n, String[] c, int[] yLevel, byte[] p, byte[] m, byte[] t, byte[] f) {
        //TO DO
        int minIndex = 0;
        String tempt = " ";
        for (int x = 0; x < n.length - 1; x++){
            minIndex = x;
            for (int y = x + 1; y < n.length; y++)

                if (n[y].compareToIgnoreCase(n[minIndex]) < 0)
                    minIndex = y;

                if (minIndex != x){
                    tempt = n[x];
                    n[x] = n[minIndex];
                    n[minIndex] = tempt;

                    String dummy = id[x];
                    id[x] = id[minIndex];
                    id[minIndex] = dummy;

                    dummy = c[x];
                    c[x] = c[minIndex];
                    c[minIndex] = dummy;

                    int a = yLevel[x];
                    yLevel[x] = yLevel[minIndex];
                    yLevel[minIndex] = a;

                    byte y = p[x];
                    p[x] = p[minIndex];
                    p[minIndex] = y;

                    y = m[x];
                    m[x] = m[minIndex];
                    m[minIndex] = y;

                    y = t[x];
                    t[x] = t[minIndex];
                    t[minIndex] = y;

                    y = f[x];
                    f[x] = f[minIndex];
                    f[minIndex] = y;
                }
        }

    } // end of sortBasedOnNames method

    /**
     * Show the elements of the arrays on the screen.
     **/

    public static void showData(String[] id, String[] n, String[] c, int[] y, byte[] p, byte[] m, byte[] t, byte[] f) {
        System.out.printf("%-10s%-25s%-10s%-5s%-6s%-6s%-6s%-6s%n", "ID #", " Name", "Course", "Year", "PG", "MG", "TFG", "FG");
        for (int x = 0; x < n.length; x++)
            System.out.printf("%-10s%-25s%-10s%-5d%-6d%-6d%-6d%-6d%n", id[x], n[x], c[x], y[x], p[x], m[x], t[x], f[x]);
    } // end of showData method

} // end of StudentRecordsViaParallelArrays class
