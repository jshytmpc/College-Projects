import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * NAME: JOSHUA TIMPAC
 * ID: 2212443
 */

public class CSVBuffered {
    public static int size = 0; // size of the data
    static ArrayList<Company> companies = new ArrayList<>(); // Arraylist container for the csv
    static Scanner kb = new Scanner(System.in);

    /**This is the CSV Buffered reader
     *
     */

     static ArrayList<Company> readCompanyCSV(String filename) {
        // Initialize arraylist
        Path pathFile = Paths.get(filename);

        // Java Buffered reader instance
        try (BufferedReader br = Files.newBufferedReader(pathFile, StandardCharsets.US_ASCII)) {

            String fLine = br.readLine(); // Reads the very first line

            while (fLine != null) { // Reads all the lines

                String[] data = fLine.split(","); //string list to read all the data in the csv and also splitting using the comma(,) delimiter
                Company company = Functions.createCompany(data);

                companies.add(company); //adds new company data to the arraylist from the scanner

                fLine = br.readLine(); //reads the next line before looping if the next line is null it will then do a runtime exception (I think?)
                size++;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return companies;
    }



}
