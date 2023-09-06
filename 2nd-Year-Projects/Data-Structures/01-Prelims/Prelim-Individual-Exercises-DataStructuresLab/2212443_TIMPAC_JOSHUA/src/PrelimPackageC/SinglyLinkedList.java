package PrelimPackageC;

class Node{
    public String nameAnimal;
    public int quantity;
    public Node next;

    public Node(int quantity, String nameAnimal) { // Constructor for current added node
        this.nameAnimal = nameAnimal;
        this.quantity = quantity;
    }


    public Node(int quantity , String nameAnimal, Node next) { // Constructor for next node
        this.quantity = quantity;
        this.nameAnimal = nameAnimal;
        this.next = next;
    }

}

class SinglyLinkedList<Animals> implements MyList<Animals>  {

    private Node head;
    private Node tail;
    private int size;



    public SinglyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int quantity, String nameAnimal) { // Inserting new node in the very first
        if (head == null) {
            add(quantity, nameAnimal);
            return;
        }
        Node newNode = new Node(quantity, nameAnimal);
        newNode.next = head;
        head = newNode;
        size++;
    }


    public void insertLast(int quantity, String nameAnimal) { // Inserting new node in the very end
        if(tail == null) {
            add(quantity, nameAnimal);
        }
        Node newNode = new Node(quantity, nameAnimal);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertToIndex(int quantity, String nameAnimal, int index){
        if (head == null) {
            add(quantity, nameAnimal);
        }
        if (tail == null) {
            add(quantity, nameAnimal);
        }

        Node temp = head;
        for (int i = 1; i < index; i++){
            temp = temp.next;
        }
        Node newNode = new Node(quantity, nameAnimal);
        temp.next = newNode;
        size++;

    }

    public void add(int quantity, String nameAnimals) { // Adds new node and stacks it (Combination of the two functions above
        Node newNode = new Node(quantity, nameAnimals);

        if (head == null) {
            head = newNode;
        }

        else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public Node getIndex(int index) { // Gets/returns the index of a specific node
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        int quantity = head.quantity;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return quantity;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = getIndex(size - 2);
        int quantity = tail.quantity;
        tail = secondLast;
        tail.next = null;
        size--;
        return quantity;
    }

    public int delete(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size) {
            deleteLast();
        }
        Node prev = getIndex(index-1);
        int quantity = prev.next.quantity;
        prev.next = prev.next.next;
        size--;
        return quantity;
    }

    public void display() {
        Node temp = head;
        System.out.println("The size of your list is: " + size) ;
        while (temp != null) {
            System.out.print(temp.quantity + " " + temp.nameAnimal + ", ");
            temp = temp.next;
        }
        System.out.println();
    }



}
