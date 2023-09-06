package PrelimPackageE;

public interface MyList<Animals> {

    public void insertToIndex(int quantity, String nameAnimal, int index); //inserts to a specific index
    public void add(int quantity, String nameAnimals); //adds a new node
    public void delete(String nameAnimals);
    public void display(); //displays all nodes and the size

    }
