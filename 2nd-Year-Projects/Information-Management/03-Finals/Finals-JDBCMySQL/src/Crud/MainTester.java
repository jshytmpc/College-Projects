package Crud;

import Constructors.Registration;
import Constructors.Subscriber;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTester {
    private static final Scanner kb = new Scanner(System.in);
    static RegistrationCRUD regCrud = new RegistrationCRUD();

    public static void main(String[] args) {
        SubscriberCRUD subCrud = new SubscriberCRUD();
        int choice;
        introduction();
        do{
            menu();
            choice = enterChoice(1,5);
            switch (choice) {
                case 1 -> {
                    while(true) {
                            do{
                                regMenu();
                                choice = enterChoice(1,3);
                                if (choice == 1) {
                                    boolean successful = false;
                                    while (!successful) {
                                        try {
                                            System.out.println("Enter your user ID");
                                            int us = Integer.parseInt(kb.nextLine());
                                            if (subCrud.checkUserId(us)) {
                                                throw new SQLException("User ID Does not Exist");
                                            }
                                                regCrud.createPhoneNo(enterRegistrationInfo(), us);
                                            successful = true;
                                        } catch (NumberFormatException e) {
                                            System.out.println();
                                            System.out.println("Error: Input should be a number");
                                            System.out.println();
                                        } catch (SQLException e) {
                                            System.out.println();
                                            System.out.println(e);
                                            System.out.println();
                                        }
                                    }
                                }
                                if( choice == 2) {
                                    try {
                                        System.out.println("--REGISTER NEW USER--");
                                        Registration regData = enterRegistrationInfo();
                                        subCrud.createSubscriberInfo(enterSubscriberData());
                                        regCrud.createPhoneNo(regData, subCrud.get());
                                    } catch (InputMismatchException | NumberFormatException e) {
                                        System.out.println();
                                        System.out.println("Error: Please enter only numbers");
                                        System.out.println("Please Reenter Again");
                                        System.out.println();
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                    }
                            } while (choice != 3);
                            break;
                    }
                }

                case 2 -> {
                    System.out.println();
                    System.out.println("SIM REGISTRATION LIST");
                    subCrud.read();
                }

                case 3 -> {
                    System.out.println();
                    System.out.println("---UPDATE USER INFORMATION---");
                    boolean success = false;
                    while(!success) {
                        try {
                            System.out.println("Enter your User ID:");
                            int us = Integer.parseInt(kb.nextLine());
                            if (subCrud.checkUserId(us)) {
                                throw new SQLException("User ID Does not Exist");
                            }
                            subCrud.update(enterSubscriberData(),us);
                            success = true;
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Error: Input should be a number");
                            System.out.println();
                        } catch (SQLException e) {
                            System.out.println();
                            System.out.println(e);
                            System.out.println();
                        }
                    }
                }

                case 4-> {
                    System.out.println();
                    System.out.println("---DELETE USER INFORMATION---");
                    boolean success = false;
                    while(!success) {
                        try {
                            System.out.println("Enter your User ID:");
                            int us = Integer.parseInt(kb.nextLine());
                            if (subCrud.checkUserId(us)) {
                                throw new SQLException("User ID Does not Exist");
                            }
                            subCrud.delete(us);
                            success = true;
                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Error: Input should be a number");
                            System.out.println();
                        } catch (SQLException e) {
                            System.out.println();
                            System.out.println(e);
                            System.out.println();
                        }
                    }
                }
            }
        }while (choice != 5);
        System.out.println("Thank you for using this program");
    }

    private static int enterChoice(int min, int max) {
        int choice = 0;
        while(choice < min || choice > max) {
            try {
                System.out.println();
                System.out.println("Enter your choice:");
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

    private static Registration enterRegistrationInfo() throws SQLException {
        System.out.println("Enter your Phone number:");
        String p = kb.nextLine();
        if(p.length() != 11){
            throw new SQLException("Error: Please enter 11 digits");
        }
        if (!regCrud.checkPhoneNumber(Long.parseLong(p))) {
            throw new SQLException("The Number already exists");
        }
        System.out.println("Enter type of ownership:");
        String o = kb.nextLine();
        System.out.println("Enter type of network:");
        String n = kb.nextLine();
        return new Registration(Long.parseLong(p),o ,n);
    }

    private static Subscriber enterSubscriberData() {
                System.out.println("Enter your Firstname:");
                String f = kb.nextLine();
                System.out.println("Enter your Lastname:");
                String l = kb.nextLine();
                System.out.println("Enter your Middlename:");
                String m = kb.nextLine();
                System.out.println("Enter you Suffix(Optional):");
                String sf = kb.nextLine();
                System.out.println("Enter your Birthdate(mm/dd/yyyy):");
                String bd = kb.nextLine();
                System.out.println("Enter your Sex(Male|Female):");
                String sx = kb.nextLine();
                System.out.println("Enter your Nationality:");
                String n = kb.nextLine();
                System.out.println("Enter your Province:");
                String p = kb.nextLine();
                System.out.println("Enter your City:");
                String c = kb.nextLine();
                System.out.println("Enter your Unit:");
                int u = Integer.parseInt(kb.nextLine());
                System.out.println("Enter your Street:");
                String str = kb.nextLine();
                System.out.println("Enter your Barangay:");
                String br = kb.nextLine();
                System.out.println("Enter your Zipcode");
                int zp = Integer.parseInt(kb.nextLine());
                return new Subscriber(f, l, m, sf, bd, sx, n, p, c, u, str, br, zp);
    }

    private static void introduction() {
        System.out.println("+-------------------------------+");
        System.out.println("|      MYSQL CRUD OPERATIONS    |");
        System.out.println("|_______________________________|");
        System.out.println("|         CARINO, Miguel        |");
        System.out.println("|         GALAPON, Daniel       |");
        System.out.println("|         MAYANGAO, Mike        |");
        System.out.println("|         TIMPAC, Joshua        |");
        System.out.println("+-------------------------------+");
    }

    private static void menu() {
        System.out.println("+-------------------------------+");
        System.out.println("|              MENU             |");
        System.out.println("|_______________________________|");
        System.out.println("|    1. Create/Register a Sim   |");
        System.out.println("|    2. Read Sim list           |");
        System.out.println("|    3. Update a Sim User       |");
        System.out.println("|    4. Delete a Sim User       |");
        System.out.println("|    5. Exit                    |");
        System.out.println("+-------------------------------+");
    }

    private static void regMenu() {
        System.out.println("+-------------------------------+");
        System.out.println("|         Register Menu         |");
        System.out.println("|_______________________________|");
        System.out.println("|    1. Register a new sim      |");
        System.out.println("|    2. Register a new user     |");
        System.out.println("|    3. Exit                    |");
        System.out.println("+-------------------------------+");
    }
}
