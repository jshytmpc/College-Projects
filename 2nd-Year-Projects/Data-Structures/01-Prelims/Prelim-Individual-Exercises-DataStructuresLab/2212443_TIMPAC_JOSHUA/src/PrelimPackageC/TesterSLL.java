package PrelimPackageC;

public class TesterSLL extends SinglyLinkedList {
    public static void main(String args []) {
        SinglyLinkedList SLL = new SinglyLinkedList();

        SLL.add(32,"Monkeys");
        SLL.add(5,"Zebras");
        SLL.add(3,"Lions");
        SLL.add(21,"Donkeys");
        SLL.display();
        SLL.insertFirst(31, "Dogs");
        SLL.display();
        SLL.insertLast(15, "Cats");
        SLL.display();
        SLL.insertToIndex(35, "cammels",5);
        SLL.display();
        SLL.deleteFirst();
        SLL.display();
        SLL.deleteLast();
        SLL.display();
        SLL.delete(2);
        SLL.display();
    }

}
