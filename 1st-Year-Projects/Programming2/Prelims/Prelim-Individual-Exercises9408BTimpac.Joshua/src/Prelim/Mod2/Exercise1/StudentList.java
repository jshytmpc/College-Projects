package Prelim.Mod2.Exercise1;
import java.util.Scanner;

public class StudentList extends Student {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Student[] list;
        int number;

        System.out.print("How many students will be listed? ");
        number = Integer.parseInt(keyboard.nextLine());
        list = new Student[number];



        System.out.println("Enter the student information.");
        for (int x = 0; x < list.length; x++) {
            System.out.println("For student " + (x + 1) + " :");
            list[x] = readStudent();
        }
        System.out.println();
        System.out.println("Unsorted List");
        showList(list);
        System.out.println();
        System.out.println("Sorted List");
        sortList(list);
        showList(list);
        System.exit(0);
    }
    private static void showList(Student[] studs) {
        for (int x = 0; x < studs.length; x++) {
            System.out.println(studs[x].toString());
        }
    }
    private static Student readStudent() {
        System.out.print("first name: ");
        String f = keyboard.nextLine();
        System.out.print("middle name: ");

        String m = keyboard.nextLine();
        System.out.print("last name: ");
        String l = keyboard.nextLine();
        System.out.print("age: ");
        int a = Integer.parseInt(keyboard.nextLine());
        System.out.print("grade point average: ");
        double g = Double.parseDouble(keyboard.nextLine());
        Student s = new Student(f, m, l, a, g);
        return s;
    }

    // Warning! using the last name as the sort key is not sufficient for a realistic set of records
    // This method needs improvement

    private static void sortList(Student[] s) {
        Student temp;
        int minIndex = 0;

        for (int x = 0; x < s.length - 1; x++) {
            minIndex = x;
            for (int y = x + 1; y < s.length; y++) {
                if
                (s[minIndex].getLastName().compareToIgnoreCase(s[y].getLastName()) > 0)
                    minIndex = y;
                else if ((s[minIndex].getFirstName().compareToIgnoreCase(s[y].getFirstName()) > 0))
                    minIndex = y;
                else if ((s[minIndex].getMidName().compareToIgnoreCase(s[y].getMidName()) > 0))
                    minIndex = y;
            }
            if (minIndex != x) {
                temp = s[x];
                s[x] = s[minIndex];
                s[minIndex] = temp;
            }
        }

    } // end of sortList method

} // end of class
