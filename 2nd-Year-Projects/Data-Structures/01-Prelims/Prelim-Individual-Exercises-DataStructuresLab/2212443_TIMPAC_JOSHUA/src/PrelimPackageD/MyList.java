package PrelimPackageD;

public interface MyList<Animals> {

    public int size(); //gets the size of the list
    public void insertAfterIndex(int index, int quantity, String nameAnimal); //inserts to a specific index
    public void add(int quantity, String nameAnimals); //adds a new node
    public void display(); //displays all nodes and the size

    }
