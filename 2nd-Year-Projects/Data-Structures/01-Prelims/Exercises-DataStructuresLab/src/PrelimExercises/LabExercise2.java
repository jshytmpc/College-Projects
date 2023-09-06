package PrelimExercises;
import java.io.*;

    /*
Name: JOSHUA TIMPAC
Date: AUGUST 31, 2022
Exercise Name and Number: LabExercise2

Be reminded that our course (Data Structures) covers analysis of algorithms. Hence, we must be familiar
with some fundamental algorithms. Linear Search is one of the fundamental algorithms in computer
programming.

Problem:
1. Create a project using the IntelliJIDEA IDE
2. Let the project contain a package called prelim.exercises
3. Include in the package the class that you have created for the previous exercise ( The class that
applied the Selection Sort Algorithm)
3. Create another executable class that implements/illustrates the Linear Search Algorithm. Let this
class be in the same package (prelim.exercises)
- The class should have a method that implements the Linear Search Algorithm. The method should
have a 1-dimensional array of string* and a search key as formal parameters.
- The class should have a method that displays elements of a 1-dimensional array
- In the code( e.g. in the main method or run method), declare a one-dimensional array of strings. For
this exercise, you may assign the elements of the array upon declaring the array (The array should have
at least 10 elements)
- Let the program show the elements of the array before the searching happens
- Let the program search for a specific element from the array
- Show that sample output of the program through multiple line comments in the source file ( i.e. After
running the programming, copy and paste the output within a comment section of the source code).

*You may create an array of objects of a user-defined class. Hence, you will search from the array an
object with a specified attribute.


*/

public class LabExercise2 {

    void showIntroduction(){
        System.out.println();

        System.out.println("Name: JOSHUA TIMPAC");
        System.out.println("Lab Exercise 2");
        System.out.println("------------------------");
        System.out.println("Linear Search Algorithm");
        System.out.println();


    }


    /** Method that implements the Linear Search Algorithm
     1.Set index to 0
     2.Search for the smallest element in the array
     3.Swap with value with the element at the Min_Index
     4. Increment Min_Index to point to next element
     5. Repeat until the position of string is found
     */

    public void arraySearch(String[]arr, String keySearch) {
        for (int index = 0; index < arr.length ; index ++) {
            if (arr[index].equalsIgnoreCase(keySearch))
                System.out.println("The Word found at position:" + (index) );
            }
        }


    void showElements(String arr[]){
        int a = arr.length;
        for(int index = 0; index < arr.length ; index ++)
        {
            System.out.println(index+": "+arr[index]);
        }

        System.out.println();
    }



    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arr[] = {"Joshua", "Ian", "Ace", "Clive", "Betty", "Daniel", "Fujitora", "Eden", "Gemma", "Heather"};
        LabExercise2 ob = new LabExercise2();
        int a = arr.length;

        ob.showIntroduction();
        ob.showElements(arr);
        System.out.println("Input the string you are looking for: ");
        String search1 = br.readLine();
        System.out.println("The word you typed is: " + search1);
        System.out.println("---------------------------------");
        System.out.println();
        ob.arraySearch(arr, search1);
    }
}
