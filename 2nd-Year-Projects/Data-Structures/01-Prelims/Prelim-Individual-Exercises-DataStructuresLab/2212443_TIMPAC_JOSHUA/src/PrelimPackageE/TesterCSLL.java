package PrelimPackageE;

public class TesterCSLL extends CircularSinglyLinkedList {
    public static void main(String args []) {
        CircularSinglyLinkedList CSLL = new CircularSinglyLinkedList();

        CSLL.add(32,"Monkeys");
        CSLL.add(5,"Zebras");
        CSLL.add(3,"Lions");
        CSLL.add(21,"Donkeys");
        CSLL.display();
        CSLL.insertToIndex(12,"Dogs", 10);
        CSLL.display();
        CSLL.delete("Monkeys");
        CSLL.display();


    }

}
