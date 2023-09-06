import java.util.*;

public class Functions extends CSVBuffered {

    static ArrayList<Company> companies = readCompanyCSV("/Users/joshy/Downloads/organizations-1000-timpac.csv");
    /**
     * Creates Arraylist out of the CSV data
     */


    // Creates an arraylist from the metadata from CSV file
    static Company createCompany(String[] metadata) { //meta data utility to organize data of data
        int ind = Integer.parseInt(metadata[0]);
        String orgId = metadata[1];
        String name = metadata[2];
        String website = metadata[3];
        String country = metadata[4];
        int date = Integer.parseInt(metadata[5]);
        String industry = metadata[6];
        int numEmployees = Integer.parseInt(metadata[7]);

        return new Company(ind,orgId,name,website,country,date,industry,numEmployees); //creates returns a company of this metadata
    }

    /**
     * Below are the different Functions
     */

    static void printCompany() { // Just prints out the company details
        for (Company comp : companies) {
            System.out.println(comp);
            size++;
        }
    }

    static void getSize() { // Gets and prints the size of the arraye
        System.out.println("Value count: " + size);
    }

    static void getCompany() {
        int myChoice;
        companyMenu();
        do {
            myChoice = enterChoice(1, 3);
            switch (myChoice) {
                case 1 -> getCompanyTxt();
                case 2 -> getCompanyNum();
            }
            companyMenu();
        } while (myChoice != 3);
    }

    static void getCompanyNum() { // This function returns gets the inputted element and returns the corresponding company.
        System.out.println("Enter LOOKUP Value: ");
        try {
            int numElement = kb.nextInt();
            // This is a for loop that matches the input to the Name
            for (Company comp : companies) {
                if (Objects.equals(comp.getIndex(), numElement)) {
                    System.out.println("The Company data is: " + comp);

                } else if (Objects.equals(comp.getDate(), numElement)) {
                    System.out.println("The company data is: " + comp);

                } else if (Objects.equals(comp.getNumEmployees(), numElement)) {
                    System.out.println("The company data is: " + comp);

                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please try again");
        }
    }

    //This is a special function that retrieves the data from the array
    static void getCompanyTxt() {
        System.out.println("Enter LOOKUP Value: ");
        String txtElement = kb.nextLine();

        // This is a for loop that matches the input to the Name
        if(true) {
            for (Company comp : companies) {
                if (Objects.equals(comp.getName(), txtElement)) {
                    System.out.println();
                    System.out.println("Successfully found!");
                    System.out.println("The Company data is: " + comp);
                    return;
                } else if (Objects.equals(comp.getOrgId(), txtElement)) {
                    System.out.println();
                    System.out.println("Successfully found!");
                    System.out.println("The Company data is: " + comp);
                    return;
                } else if (Objects.equals(comp.getWebsite(), txtElement)) {
                    System.out.println();
                    System.out.println("Successfully found!");
                    System.out.println("The Company data is: " + comp);
                    return;
                } else if (Objects.equals(comp.getCountry(), txtElement)) {
                    System.out.println();
                    System.out.println("Successfully found!");
                    System.out.println("The Company data is: " + comp);
                    return;
                }  else if (Objects.equals(comp.getIndustry(), txtElement)) {
                    System.out.println();
                    System.out.println("Successfully found!");
                    System.out.println("The company data is: " + comp);
                    return;
                }
            }
        }
        System.out.println();
        System.out.println("Error: Company cannot be retrieved. The element did not match any data in the list.");
    }

    static void sort() { // This function filters out each metadata
        int myChoice;
        menuSort();
        do {
            myChoice = enterChoice(1, 8);
            switch (myChoice) {
                case 1 -> { // Sorting Company list by organization ID
                    companies.sort(new orgIdCompare());
                    System.out.println("Sorted by ORG ID");
                        for (Company comp : companies) {
                            System.out.println(comp);
                        }
                }
                case 2 -> { // Sorting Company list by name
                    companies.sort(new nameCompare());
                    System.out.println("Sorted by NAMES");
                        for (Company comp : companies) {
                            System.out.println(comp);
                        }
                }
                case 3 -> {
                    companies.sort(new webCompare());
                    System.out.println("Sorted by WEBSITES");
                        for (Company comp : companies) {
                            System.out.println(comp);
                        }
                }
                case 4 -> {
                    companies.sort(new countryCompare());
                    System.out.println("Sorted by COUNTRY");
                    for (Company comp : companies) {
                        System.out.println(comp);
                    }
                }
                case 5 -> {
                    companies.sort(new dateCompare());
                    System.out.println("Sorted by FOUNDING DATE");
                    for (Company comp : companies) {
                        System.out.println(comp);
                    }
                }
                case 6 -> {
                    companies.sort(new indusCompare());
                    System.out.println("Sorted by INDUSTRY");
                    for (Company comp : companies) {
                        System.out.println(comp);
                    }
                }
                case 7 -> {
                    companies.sort(new numEmpCompare());
                    System.out.println("Sorted by NUMBER OF EMPLOYEES");
                    for (Company comp : companies) {
                        System.out.println(comp);
                    }
                }
            }
            menuSort();
        } while (myChoice != 8);
    }

    static void filter() { // This function filters out each metadata
        int myChoice;
        menuFilter();
        do {
            myChoice = enterChoice(1, 8);
            switch (myChoice) {
                case 1 -> { for (Company comp : companies)
                    System.out.println(comp.getName());
                }

                case 2 -> { for (Company comp : companies)
                    System.out.println(comp.getOrgId());
                }
                case 3 -> { for (Company comp : companies)
                    System.out.println(comp.getWebsite());
                }
                case 4 -> { for (Company comp : companies)
                    System.out.println(comp.getCountry());
                }
                case 5 -> { for (Company comp : companies)
                    System.out.println(comp.getDate());
                }
                case 6 -> { for (Company comp : companies)
                    System.out.println(comp.getIndustry());

                }
                case 7 -> {  for (Company comp : companies) {
                    System.out.println(comp.getNumEmployees());
                }
                }
            }
            menuFilter();
        } while (myChoice != 8);
    }

    static void averageEmp() {
        int sum = 0;
        double count = 0;
        double average;
        for (Company comp : companies) {
            sum += comp.getNumEmployees();
            count++;
        }
        average = sum/count;
        System.out.println("AVERAGE NUMBER OF EMPLOYEES");
        System.out.println(average);
    }
    static void sumEmp() {
        int sum = 0;
        for (Company comp : companies) {
            sum += comp.getNumEmployees();
        }
        System.out.println("SUM OF EMPLOYEES");
        System.out.println(sum);
    }



    // Input design for switch case that will only accept a minimum and maximum number
    public static int enterChoice(int min, int max) {
        return choice(min, max);
    }

    static int choice(int min, int max) {
        Scanner keyboard1 = new Scanner(System.in);
        int choice = 0;

        try {
            System.out.println();
            System.out.println("Enter Option:");
            choice = keyboard1.nextInt();
            if(choice < min || choice > max) {
                System.out.println("Error: Select only from numbers " + min + " and " + max);
                return choice;
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid Input. Please Enter Numbers Only.");
        }
        return (choice);
    }

    static void showIntroduction() {
        System.out.println();
        System.out.println("        --------------------------");
        System.out.println("        |--FAKE EXCEL FUNCTIONS--|");
        System.out.println("        |   by: Joshua Timpac    |");
        System.out.println("        --------------------------");
    }

    static void menu() {
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("                    MENU                   |");
        System.out.println("-------------------------------------------");
        System.out.println("1. FILTER Function                        |");
        System.out.println("2. SORTING Function                       |");
        System.out.println("3. VLOOKUP Function                       |");
        System.out.println("4. COUNT Function                         |");
        System.out.println("5. SUM Number of Employees Function       |");
        System.out.println("6. AVERAGE Number of Employees Function   |");
        System.out.println("7. PRINT CSV                              |");
        System.out.println("8. Exit                                   |");
        System.out.println("-------------------------------------------");
    }

    static void menuFilter() {
        System.out.println("-------------------------------");
        System.out.println("          FILTER MENU         |");
        System.out.println("-------------------------------");
        System.out.println("1. Filter by Names");
        System.out.println("2. Filter by Organization ID");
        System.out.println("3. Filter by Websites");
        System.out.println("4. Filter by Countries");
        System.out.println("5. Filter by Dates");
        System.out.println("6. Filter by Industry");
        System.out.println("7. Filter by Number of Employees");
        System.out.println("8. Exit");
        System.out.println("-------------------------------");
        System.out.println();
    }

    static void menuSort() {
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("          SORT MENU         |");
        System.out.println("-------------------------------");
        System.out.println("1. SORT by Organization ID");
        System.out.println("2. SORT by Names");
        System.out.println("3. SORT by Websites");
        System.out.println("4. SORT by Countries");
        System.out.println("5. SORT by Dates");
        System.out.println("6. SORT by Industry");
        System.out.println("7. SORT by Number of Employees");
        System.out.println("8. Exit");
        System.out.println("-------------------------------");
        System.out.println();
    }

    static void companyMenu() {
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("         VLOOKUP MENU         |");
        System.out.println("-------------------------------");
        System.out.println("1. LOOKUP a String Value");
        System.out.println("2. LOOKUP a Number Value");
        System.out.println("3. Exit");
        System.out.println("-------------------------------");
        System.out.println();
    }


}

