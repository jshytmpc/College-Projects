import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CRUDFunctions extends CSVReader {
    static ArrayList<Course> curr = readCSV();
    static Scanner sc = new Scanner(System.in);
    static String line = "-";

    /**
     * Creates an Arraylist out of each row in the CSV file
     *
     * @param metadata
     * @return's the object Course constructor and adds it in the arraylist
     */

    static Course createCourse(String[] metadata) {

        int year = Integer.parseInt(metadata[0]);
        int term = Integer.parseInt(metadata[1]);
        String courseNo = metadata[2];
        String courseDesc = metadata[3];
        float unit = Float.parseFloat(metadata[4]);
        String preQ = metadata[5];
        int grades = Integer.parseInt(metadata[6]);

        return new Course(year, term, courseNo, courseDesc, unit, preQ, grades);
    }

    static void lineBuilder() {
        System.out.println("+" + line.repeat(163) + "+");
    }

    /**
     * Prints out the whole course term
     */

    static void printWholeCourse() {
        float sum = 0;
        lineBuilder();
        System.out.printf("| %-15s| %-110s| %-10s| %-20s | \n", "Course Number", "Course Description", "Unit", "Pre-requisite");
        lineBuilder();
        for (Course comp : curr) {
            System.out.println(comp);
            sum += comp.getUnit();

        }
        lineBuilder();
        System.out.printf("|%-15s %-112s| %-10s %-22s| \n", " Total Units", "", sum, "");
        lineBuilder();
    }

    /**
     * Print's out the arraylist of courses TERMS
     *
     * @param year - is used for isolating year level
     * @param term - us used for isolation term level
     */

    static void printCourseTerm(int year, int term) {
        float sum = 0;
        lineBuilder();
        System.out.printf("| %-15s| %-110s| %-10s| %-20s | \n", "Course Number", "Course Description", "Unit", "Pre-requisite");
        lineBuilder();
        for (Course comp : curr) {
            if (comp.getYear() == year && comp.getTerm() == term) {
                System.out.println(comp);
                sum += comp.getUnit();
            }
        }
        lineBuilder();
        System.out.printf("|%-15s %-112s| %-10s %-22s| \n", " Total Units", "", sum, "");
        lineBuilder();
    }

    /**
     * Prints out courses but with grades
     *
     * @param year
     */

    static void printCourseGrades(int year, int term) {
        float sum = 0;
        int count = 0;
        int average = 0;
        boolean found = false;
        lineBuilder();
        System.out.printf("| %-15s| %-110s| %-10s| %-20s | \n", "Course Number", "Course Description", "Unit", "Grades");
        lineBuilder();
        for (Course comp : curr) {
            if (comp.getYear() == year && comp.getTerm() == term) {
                System.out.println(comp.printGrade());
                sum += comp.getUnit();
                if(comp.getGrades() == 0) {
                    found = true;
                }
                average += comp.getGrades();

                count++;
            }
        }
        if(!found) {
            average = average/count;
        }
        lineBuilder();
        System.out.printf("|%-15s %-112s| %-10s| %-22s| \n", " Total & Ave.", "", sum, average);
        lineBuilder();
    }


    /**
     * A Display menu that gives you options to view the curriculum of the BSIT Course
     */
    static void chooseTerm() {
        int choice;
        do {
            System.out.println();
            System.out.println("1-4-School Year | 5-Show Electives | 6-Show all | 7-Exit");
            switch (choice = enterChoice(1, 7, "choice")) {
                case 1 -> {
                    System.out.println();
                    System.out.println("FIRST YEAR: FIRST SEMESTER");
                    printCourseTerm(1, 1);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("FIRST YEAR: SECOND SEMESTER");
                    printCourseTerm(1, 2);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("FIRST YEAR: SHORT TERM");
                    printCourseTerm(1, 3);
                }
                case 2 -> {
                    System.out.println();
                    System.out.println("SECOND YEAR: FIRST SEMESTER");
                    printCourseTerm(2, 1);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("SECOND YEAR: SECOND SEMESTER");
                    printCourseTerm(2, 2);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("SECOND YEAR: SHORT TERM");
                    printCourseTerm(2, 3);
                }
                case 3 -> {
                    System.out.println();
                    System.out.println("THIRD YEAR: FIRST SEMESTER");
                    printCourseTerm(3, 1);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("THIRD YEAR: SECOND SEMESTER");
                    printCourseTerm(3, 2);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("THIRD YEAR: SHORT TERM");
                    printCourseTerm(3, 3);
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("FOURTH YEAR: FIRST SEMESTER");
                    printCourseTerm(4, 1);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("FOURTH YEAR: SECOND SEMESTER");
                    printCourseTerm(4, 2);

                }
                case 5 -> {
                    System.out.println();
                    System.out.println("CS ELECTIVES");
                    printCourseTerm(0, 0);
                }
                case 6 -> {
                    System.out.println("BACHELOR OF SCIENCE IN INFORMATION AND TECHNOLOGY CURRICULUM");
                    printWholeCourse();
                }

            }

        } while (choice != 7);
    }

    /**
     * A Display menu that gives you options to view the curriculum of your BSIT course with respective grades
     */

    static void termGrades() {
        int choice;
        do {
            System.out.println();
            System.out.println("1-4-School Year | 5-Exit");
            switch (choice = enterChoice(1, 5, "choice")){
                case 1 -> {
                    System.out.println();
                    System.out.println("FIRST YEAR: FIRST SEMESTER");
                    printCourseGrades(1, 1);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("FIRST YEAR: SECOND SEMESTER");
                    printCourseGrades(1, 2);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("FIRST YEAR: SHORT TERM");
                    printCourseGrades(1, 3);
                }
                case 2 -> {
                    System.out.println();
                    System.out.println("SECOND YEAR: FIRST SEMESTER");
                    printCourseGrades(1, 1);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("SECOND YEAR: SECOND SEMESTER");
                    printCourseGrades(1, 2);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("SECOND YEAR: SHORT TERM");
                    printCourseGrades(1, 3);
                }
                case 3 -> {
                    System.out.println();
                    System.out.println("THIRD YEAR: FIRST SEMESTER");
                    printCourseGrades(1, 1);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("THIRD YEAR: SECOND SEMESTER");
                    printCourseGrades(1, 2);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("THIRD YEAR: SHORT TERM");
                    printCourseGrades(1, 3);
                }
                case 4 -> {
                    System.out.println();
                    System.out.println("FOURTH YEAR: FIRST SEMESTER");
                    printCourseGrades(1, 1);
                    System.out.println("Press enter key to see the next courses for the next term....");
                    sc.nextLine();

                    System.out.println("FOURTH YEAR: SECOND SEMESTER");
                    printCourseGrades(1, 2);

                }

            }

        } while (choice != 5);
    }

    private static int courseCheck() {
        boolean found = false;
        int index = 0;
        do {
            System.out.println("Enter the desired course number you want to edit:");
            String courseNo = sc.nextLine();
            for (Course comp : curr) {
                if (Objects.equals(comp.getCourseNo(), courseNo)) {
                    lineBuilder();
                    System.out.printf("| %-15s| %-110s| %-10s| %-20s | \n", "Course Number", "Course Description", "Unit", "Pre-requisite");
                    lineBuilder();
                    System.out.println(comp);
                    index = curr.indexOf(comp);
                    lineBuilder();
                    found = true;
                }
            }
            if(!found) {
                System.out.println();
                System.out.println("Course not found");
            }
        }while (!found);
        System.out.println("Course has been found");
        return index;
    }

    static void updateCourse() {
        Course comp = curr.get(courseCheck());
        try {
            System.out.println();
            System.out.println("Enter a new course Number: ");
            String newCourseNo = sc.nextLine();
            System.out.println("Enter a new course Description: ");
            String newCourseDesc = sc.nextLine();
            System.out.println("Enter the new units for new course: ");
            float newUnits = Float.parseFloat(sc.nextLine());
            comp.setCourseNo(newCourseNo);
            comp.setCourseDesc(newCourseDesc);
            comp.setUnit(newUnits);

            FileWriter writer = new FileWriter("src/Courses.csv");;
            writer.write("year" + "," + "term" + "," + "courseNo" + "," + "courseDesc" + "," + "unit" + "," + "preQ" + "," + "grades" + "\n");

            for (Course comp1 : curr) {
                writer.write(comp1.getYear() + "," + comp1.getTerm() + "," + comp1.getCourseNo() + "," + comp1.getCourseDesc() + "," + comp1.getUnit() + "," + comp1.getPreQ() + "," + comp1.getGrades() + "\n");
            }
            writer.close();
        }catch (IOException e) {
            System.out.println("File not found");
        }catch (NumberFormatException e) {
            System.out.println("Error: Please use float numbers only");
        }
    }

    static void enterGrade()  {
            Course comp = curr.get(courseCheck());
        try {
            System.out.println();
            int newGrade=enterChoice(65,99, "Grade");

            comp.setGrade(newGrade);

            FileWriter writer2 = new FileWriter("src/Courses.csv");;
            writer2.write("year" + "," + "term" + "," + "courseNo" + "," + "courseDesc" + "," + "unit" + "," + "preQ" + "," + "grades" + "\n");

            for (Course comp1 : curr) {
                writer2.write(comp1.getYear() + "," + comp1.getTerm() + "," + comp1.getCourseNo() + "," + comp1.getCourseDesc() + "," + comp1.getUnit() + "," + comp1.getPreQ() + "," + comp1.getGrades() + "\n");
            }

            writer2.close();

        }catch (IOException e) {
            System.out.println("File not found");
        }catch (NumberFormatException e) {
            System.out.println("Please use numbers only");
        }

    }

    /**
     * This is a class used for limiting the options in a switch case statement.
     * It will return an error everytime you input a number that is not within the min and max.
     * @param min choice
     * @param max choice
     * @return -  choice number
     */

    private static int enterChoice(int min, int max, String input) {
        int choice = 0;
        while(choice < min || choice > max) {
            try {
                System.out.println();
                System.out.println("Enter your " + input + ":");
                choice = Integer.parseInt(kb.nextLine());
                if (choice < min || choice > max) {
                    System.out.println("Error: You must enter only a number from " + min + " to " + max);
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Error: Please enter only numbers");
            }
        }
        return choice;
    }



}
