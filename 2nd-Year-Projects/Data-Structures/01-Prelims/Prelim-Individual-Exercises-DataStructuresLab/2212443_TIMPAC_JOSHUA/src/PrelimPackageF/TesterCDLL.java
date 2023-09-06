package PrelimPackageF;

public class TesterCDLL extends  MyCircularDoublyLinkedList {
    public static void main(String[] args) {
        MyCircularDoublyLinkedList DLL = new MyCircularDoublyLinkedList();

        DLL.add(3, "Dogs");
        DLL.display();
        DLL.add(6, "Cats");
        DLL.add(10, "Chickens");
        DLL.add(18, "Cows");
        DLL.display();
        DLL.insertAfterIndex(2,8,"Cheetahs");
        DLL.display();
        DLL.insertAfterIndex(2,12,"Monkeys");
        DLL.display();
        DLL.insertAfterIndex(10,58,"Hyenas");
        DLL.display();
    }
}
