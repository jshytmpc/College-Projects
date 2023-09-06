package PrelimPackageF;

class Node {
    public int quantity;
    public String nameAnimal;
    public Node next;
    public Node prev;

    public Node(int quantity, String nameAnimal) {
        this.quantity = quantity;
        this.nameAnimal = nameAnimal;
    }
}

class MyCircularDoublyLinkedList<Animals> implements MyList<Animals> {

    private Node head;
    private Node tail;
    public int size;

    public MyCircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void add(int quantity, String nameAnimals) {
            Node newNode = new Node(quantity,nameAnimals);

            if(head == null) {
                head = newNode;
                tail = newNode;
                head.next = tail;
                head.prev = tail;
            }
                tail.next = newNode;
                newNode.next = head;
                newNode.prev = tail;
                tail = newNode;
                tail.next = head;
                head.prev = tail;
            size++;
    }

    @Override
    public void insertAfterIndex(int index, int quantity, String nameAnimals) {
        Node newNode = new Node(quantity, nameAnimals);
        Node current = tail.next;
        while(index >1 ) {
            current = current.next;
            index--;
        }
        if (current == tail) {
            add(quantity, nameAnimals);
            return;
        }
        current.next.prev = newNode;
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        size++;
    }

    @Override
    public int size() {
        System.out.println();
        System.out.println("The size of your list is: " + size);
        return size;
    }

    @Override
    public void display() {
        Node current = head;
        Node last = tail;

        size();

        if (current != null) {
            do {
                System.out.print(current.quantity + " " + current.nameAnimal + ", ");
                current = current.next;
            } while (current != head);
            System.out.println("[Goes back to head]");
        }

        System.out.println();
        System.out.println("Prints out in reverse");


            do {
                System.out.print(last.quantity + " " + last.nameAnimal + ", ");
                last = last.prev;
            } while (last != tail);
            System.out.println("[Goes back to head]");

        System.out.println();
    }

}
