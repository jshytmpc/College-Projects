package DemoUnused;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * NAME: JOSHUA TIMPAC
 * ID: 2212443
 * DEMO FILE READER FOR CSV
 * IGNORE. THIS WAS JUST FOR A TEST TO SEE WHAT WAS BETTER TO USE.
 * IN THE END IT WAS EASIER FOR ME TO USE THE BUFFERED READER
 */

public class CSVScannerDemo {
    // private static ArrayList<Company> companies = new ArrayList<>();

    public static void readCompany() throws IOException {
        String fileName = "/Users/joshy/Downloads/organizations-1000-timpac.csv";
        File file = new File(fileName);

    // parses csv file to scanner class constructor
    Scanner sc = new Scanner(file);
    sc.useDelimiter(","); // sets delimiter to use

        // StringTokenizer token = null;

        int ind = Integer.parseInt("");
        String name = "";
        String website = "";
        String country = "";
        int date = Integer.parseInt("");
        String industry = "";
        int numEmployees = Integer.parseInt("");

        while (sc.hasNext()) { //returns a boolean value
            String data = sc.next(); //gets the whole line of the data
            // token = new StringTokenizer(sc.next()); // more secured way of doing this good for payments

            System.out.println(data);


            ind = Integer.parseInt(String.valueOf(sc));
            name = sc.next();
            website = sc.next();
            country = sc.next();
            date = Integer.parseInt(sc.next());
            industry = sc.next();
            numEmployees = Integer.parseInt(sc.next());

            // Company company = new Company(ind,name,website,country,date,industry,numEmployees);
            // companies.add(company);



            //System.out.println(company.toString());

        }
        sc.close();

    }

    public static void main(String[] args) throws IOException {
        readCompany();

        /*for (Company company : companies) {
            System.out.println(company);
        }

         */
    }
}
