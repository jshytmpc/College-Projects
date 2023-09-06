package PrelimPackageA;

import java.util.*;

class FriendsList{

    public String FriendName;
    public int FriendAge;

    public FriendsList(String name, int age) { // Setter of naming convention
        this.FriendName = name;
        this.FriendAge = age;
    }

    public String getFriendName() { // Gets the name of the anime
        return FriendName;
    }


    public String toString(){ // Gets all the anime info from the list
        return FriendName + " Age: " + FriendAge;
    }
}

public class MyFixedArrayList<Friends> implements MyList<Friends> {
    Scanner Keyboard = new Scanner(System.in);
        ArrayList<FriendsList> listJoshua = new ArrayList<>(5);
        private int size;
        private final int capacity = 5;




    public void showMenu() {
        System.out.println();
        System.out.println("MENU");
        System.out.println("1. Show Menu");
        System.out.println("2. Display Capacity");
        System.out.println("3. Display List");
        System.out.println("4. Make List");
        System.out.println("5. Search an Element");
        System.out.println("6. Delete an Element");
        System.out.println("7. Insert an Element");
        System.out.println("8. Retrieve an Element");
        System.out.println("9. Exit");
    }

        public static int enterChoice(int min, int max){

            Scanner Keyboard = new Scanner(System.in);
            int choice;
            do{
                System.out.println("Do you want to add an item?");
                System.out.println("1. Yes | 2. No");
                choice = Keyboard.nextInt();
                if(choice<min || choice > max)
                    System.out.println("Invalid Choice please only enter a number from " + min + " to " + max);
            }while (choice < min || choice > max);
            return (choice);
        }
        @Override
        public FriendsList addElement() {
            int myChoice;
            do {
                myChoice = enterChoice(1, 2);
                switch (myChoice) {
                    case 1 -> {
                        if(size < capacity) {

                            System.out.println("NAME: ");
                            String fName = Keyboard.nextLine();
                            System.out.println("AGE: ");
                            int fAge = Integer.parseInt(Keyboard.nextLine());
                            listJoshua.add(new FriendsList(fName, fAge));
                            System.out.println(listJoshua);
                            size++;
                            getSize();
                        } else System.out.println("Error: You have reached the maximum capacity" + size + " of " + capacity );
                    }
                    case 2 -> {
                        System.out.println("To show the menu type 1");
                        System.out.println();
                    }
                }
            } while (myChoice != 2);
            return null;
        }



        @Override
        public int getSize() {
            System.out.print("The size of your array is: " + size + " of " + capacity);
            System.out.println();
              return size;
        }

        @Override
        public int insert(Friends data) throws ListOverflowException {
            if(size < capacity) {
                System.out.println("Enter the position you want to insert your item");
                int pos = Integer.parseInt(Keyboard.nextLine());
                System.out.println("NAME: ");
                String fName = Keyboard.nextLine();
                System.out.println("AGE: ");
                int fAge = Integer.parseInt(Keyboard.nextLine());
                FriendsList newFriend = new FriendsList(fName, fAge);
                listJoshua.add(pos, newFriend);
                size++;
                return pos;
            } else throw new ListOverflowException();
        }


        @Override
        public Friends getElement(Friends data) throws NoSuchElementException {
            System.out.println("Enter the name of the Friend you want to find: ");
            String fName = Keyboard.nextLine();
            for (FriendsList temp : listJoshua) {
                if (Objects.equals(temp.getFriendName(),fName)) {
                    System.out.println("The data of your friend has been found: " + temp);
                    return data;
                }
            }
            throw new NoSuchElementException();
        }


        @Override
        public boolean delete(Friends data) {
                if(size != 0) {
                    System.out.println("Enter name of the Friend you want to remove from the list: ");
                    String fName = Keyboard.nextLine();
                    Iterator<FriendsList> iterate = listJoshua.iterator();
                    while (iterate.hasNext()) {
                        FriendsList temp = iterate.next();
                        if (Objects.equals(temp.getFriendName(), fName)) {
                            iterate.remove();
                            size--;
                            System.out.println("Your friend " + fName + " has been removed from the list");
                            return true;
                        }
                    }
                }
            System.out.println("Data cannot be found");
            return false;
        }

        @Override
        public int search(Friends data) {
        boolean found;
            int index = 0;
            System.out.println("Enter the name of your Friend to find the position: ");
            String fName = Keyboard.nextLine();
            for (FriendsList temp : listJoshua) {
                if (Objects.equals(temp.getFriendName(), fName)) {
                    System.out.println("Your friend's data: " + temp + " has been found in position " + index);
                    return index;
                }
                index++;
            }
            System.out.println("Error: " + "Index of " + fName + " Not found");
            return index;
        }



    }

