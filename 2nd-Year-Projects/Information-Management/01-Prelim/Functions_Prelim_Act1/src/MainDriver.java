

public class MainDriver extends Functions {
    public static void main(String[] args) {

        //Switch case menu for all the different functions
        int myChoice;
        showIntroduction();
        do {
            myChoice = enterChoice(1, 8);
            switch (myChoice) {
                case 1 -> filter();
                case 2 -> sort();
                case 3 -> getCompany();
                case 4 -> getSize();
                case 5 -> sumEmp();
                case 6 -> averageEmp();
                case 7 -> printCompany();
            }
        } while (myChoice != 8);
        System.out.println("Thanks for using my program!");
    }

    public static int enterChoice(int min, int max) {
        menu();
        return choice(min, max);
    }
}
