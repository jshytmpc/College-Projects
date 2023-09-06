package PrelimPackageE;

class Node{
    public String nameAnimal;
    public int quantity;
    public Node next;

    public Node(int quantity, String nameAnimal) { // Constructor for current added node
        this.nameAnimal = nameAnimal;
        this.quantity = quantity;
    }




}

class CircularSinglyLinkedList<Animals> implements MyList<Animals> {

    private Node head;
    private Node tail;
    public int size;



    public CircularSinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }


    @Override
    public void insertToIndex(int quantity, String nameAnimal, int index) {
        Node newNode = new Node(quantity, nameAnimal);
        Node temp = tail.next;
        while(index >1 ) {
            temp = temp.next;
            index--;
        }
        if (temp == tail) {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = tail.next;
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    public void add(int quantity, String nameAnimal) { // Adds new node and stacks it (Combination of the two functions above
        Node newNode = new Node(quantity, nameAnimal);

        if (head == null) {
            head = newNode;
            tail = newNode;
            head.next = tail;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
        size++;
    }

    @Override
    public void delete(String nameAnimal) {
        Node currentNode = head;
        if (currentNode == null) {
            return;
        }
        if (currentNode.nameAnimal == nameAnimal) {
            head = head.next;
            tail.next = head;
            return;
        }
        do{
            Node nextNode = currentNode.next;
            if (nextNode.nameAnimal == nameAnimal) {
                currentNode.next = nextNode.next;
                break;
            }
            currentNode = currentNode.next;
        } while (currentNode != head );
    }


    public int getSize() {
        System.out.println("The size of your list is: " + size);
        return size;
    }

    public void display() {
        Node current = head;
        getSize();
        if (head != null) {
            do {
                System.out.print(current.quantity + " " + current.nameAnimal + ", ");
                current = current.next;
            } while (current != head);
            System.out.println("[Goes back to head]");
        }
    }



}
