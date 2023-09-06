package PrelimPackageD;

public class TesterDLL extends MyDoublyLinkedList {
    public static void main(String[] args) {
        MyDoublyLinkedList DLL = new MyDoublyLinkedList();

        DLL.add(3, "Dogs");
        DLL.display();
        DLL.add(6, "Cats");
        DLL.add(10, "Chickens");
        DLL.add(18, "Cows");
        DLL.display();
        DLL.insertAfterIndex(2,8,"Cheetahs");
        DLL.display();
        DLL.insertAfterIndex(4,12,"Monkeys");
        DLL.display();
    }
}
