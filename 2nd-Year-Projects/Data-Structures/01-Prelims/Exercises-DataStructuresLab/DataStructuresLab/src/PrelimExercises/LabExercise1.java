
/*
Name: JOSHUA TIMPAC
Date: AUGUST 24, 2022_
Exercise Name and Number: LabExercise1

Problem:
Create an executable class that implements/illustrates the Selection Sort Algorithm
- The class should have a method that implements the Selection Sort Algorithm.
The method should have a 1-dimensional array of string as formal parameter
- The class should have a method that displays elements of a 1-dimensional array
- In the code ( e.g. in the main method), declare a one-dimensional array of strings.
For this exercise, you may assign the elements of the array upon declaring the array
(The array should have at least 10 elements)
- Let the program show the elements of the array before the sorting happens
- Let the program show the elements of the array after sorting
- Show that sample output of the program through multiple line comments in the source file
( i.e. After running the programming, copy and paste the output within a comment section of the
source code).

Program Algorithm:
1. Sort Selection System
2.

*/

package PrelimExercises;

public class LabExercise1 {


        void showIntroduction(){
            System.out.println();

            System.out.println("Name: JOSHUA TIMPAC");
            System.out.println("Lab Exercise 1");
            System.out.println("------------------------");
            System.out.println("Selection Sort Algorithm");
            System.out.println();


        }

    /**
     Sorts an array of String using the Selection Sort Algorithm
     Algorithm:
     1 − Set Min_Index to 0
     2 − Search for the smallest element in the array
     3 − Swap with value with the element at the Min_Index
     4 − Increment Min_Index to point to next element
     5 − Repeat until the complete array is sorted
     */

        void sortArray(String arr[], int a) {

            for (int x = 0; x < a-1; x++) {
                int minIndex = x;
                String minStr = arr[x];

                for (int y = x + 1; y < a; y++) {

                    if (arr[y].compareTo(minStr) < 0) {
                        minStr = arr[y];
                        minIndex = y;
                    }
                }

                    if (minIndex != x) {
                        String temp = arr[minIndex];
                        arr[minIndex] = arr[x];
                        arr[x] = temp;
                    }
            }
        }

        /** Displays the elements of an array of strings
         Algorithm:
         1. Set minIndex to 0 to assume that the first element is the lowest.
         2. Check if the next element is lower than the previous element
         3. Increment minIndex to next element if it is equal to the previous element
         4. Print element

         **/


        void showElements(String arr[]){
            int a = arr.length;
            for(int x = 0; x < a; x++)
            {
                System.out.println(x+": "+arr[x]);
            }

            System.out.println();
        }


        public static void main(String[] args) {

            String arr[] = {"Joshua", "Ian", "Ace", "Clive", "Betty", "Daniel", "Fujitora", "Eden", "Gemma", "Heather"};
            LabExercise1 ob = new LabExercise1();
            int a = arr.length;

            ob.showIntroduction();
            System.out.println("The Given array is");
            System.out.println("-------------------");
            ob.showElements(arr);
            ob.sortArray(arr, a);
            System.out.println("The Sorted array is");
            System.out.println("-------------------");
            ob.showElements(arr);
        }
    }

