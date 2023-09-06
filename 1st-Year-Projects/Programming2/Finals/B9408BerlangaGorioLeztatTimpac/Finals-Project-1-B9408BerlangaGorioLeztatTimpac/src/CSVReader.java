import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static int size = 0;
    static ArrayList<Course> curr = new ArrayList<>();
    static Scanner kb = new Scanner(System.in);

    public static ArrayList<Course> readCSV() {
        Path pathFile = Paths.get("src/Courses.csv");


        try (BufferedReader br = Files.newBufferedReader(pathFile)) {

            String fLine = br.readLine();
            fLine = br.readLine(); // Skips the first line

            while (fLine != null) {
                String[] data = fLine.split(",");
                Course cls = CRUDFunctions.createCourse(data);

                curr.add(cls);

                fLine = br.readLine();
                size++;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return curr;
    }
}
