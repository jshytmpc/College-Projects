package PrelimPackageD;

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

class MyDoublyLinkedList<Animals> implements MyList<Animals> {

    private Node head;
    private Node tail;
    public int size;

    public MyDoublyLinkedList() {
        size = 0;
    }

    @Override
    public void add(int quantity, String nameAnimals) {
            Node newNode = new Node(quantity,nameAnimals);
            if(head == null) {
                head = tail = newNode;
                head.prev = null;
            }
            else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            tail.next = null;
            size++;
    }

    public Node getIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void insertAfterIndex(int afterIndex, int quantity, String nameAnimals) {
        Node currentNode = getIndex(afterIndex);

        if (currentNode == null) {
            add(quantity, nameAnimals);
            return;
        }

        Node nextNode = getIndex(afterIndex+1);



        Node newNode = new Node(quantity, nameAnimals);
        currentNode.next = newNode;
        newNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = newNode;
        }
        newNode.prev = currentNode;
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

        while (current != null) {

            System.out.print(current.quantity + " " + current.nameAnimal + ", ");
            last = current;
            current = current.next;
        }
        System.out.println();
        System.out.println("Prints out in reverse");
        while (last != null) {
            System.out.print(last.quantity + " " + last.nameAnimal + ", ");
            last = last.prev;
        }
        System.out.println();
    }

}
