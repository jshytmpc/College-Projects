package MSPowerPoint;


import MSPowerPoint.Interfaces.MySlide;

import java.util.*;

class Node {
    public ArrayList<SlideContent> slides;
    public Node next;
    public Node prev;
    public int noPoint;

    public Node(ArrayList<SlideContent> slides) {
        this.slides = slides;
    }

}

class MyDoublyLinkedList<Slides> implements MySlide {
    private Node head;
    private Node tail;
    public int size = 0;

    Scanner kb = new Scanner(System.in);
    ArrayList<SlideContent> slideContent = new ArrayList<>();

    public void showIntroduction() {
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("POWERPOINT PRESENTATION BOOTLEG");
        System.out.println("Programmed by: ");
        System.out.println("Timpac,Joshua");
        System.out.println("Gorio, Ian");
        System.out.println("Mayangao, Mike");
        System.out.println("-------------------------------");
        System.out.println();
    }

    public void showMenu() {
        System.out.println();
        System.out.println("Slide MENU");
        System.out.println("1. Create a slide");
        System.out.println("2. Insert After slide");
        System.out.println("3. Insert Before slide");
        System.out.println("4. Read/Display all slides");
        System.out.println("5. Update a slide");
        System.out.println("6. Delete a slide");
        System.out.println("7. Exit");
    }

    public void slideGenerator() { // this method allows the user to create their own content
        System.out.println("Title: ");
        String title = kb.nextLine();
        System.out.println("Body: ");
        String desc = kb.nextLine();
        slideContent.add(new SlideContent(title, desc));
    }


    public int getSlideSize() {
        System.out.println();
        System.out.println("Slide size: " + size);
        return size;
    }


    @Override
    public void createSlides() { // this creates the container for the slide content (InsertLast Method)
        slideContent.clear();
        slideGenerator();
        Node newNode = new Node(new ArrayList<>(slideContent));

        if(head == null) {
            head = tail = newNode;
            head.prev = null;
            tail.next = null;
            size++;
            System.out.println("Slide created Successfully");
            System.out.println(slideContent);
            getSlideSize();
            return;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        tail.next = null;
        size++;

        System.out.println("Slide created Successfully");
        System.out.println(slideContent);
        getSlideSize();
        showMenu();
    }

    @Override
    public void readAllSlides() { // this method displays all the slides created
        Node current = head;
        System.out.println();
        System.out.println("Slides: ");

        if (head == null) {
            System.out.println("(Empty)");
        }

        while (current != null) {

            System.out.print(" <-" + current.slides + "-> ");
            tail = current;
            current = current.next;
        }
        getSlideSize();
    }


    @Override
    public void updateSlide(int index){

    deleteSlide(index);
    insertBeforeIndex(index);
    showMenu();
    }


    @Override
    public void deleteSlide(int index) { // this method deletes the slide through the user providing the index

        if (head == null) {
            System.out.println("Error: The list is empty");
            return;
        }


        if (index == 0) { // deletes the first slide
            head = head.next;
            if (head == null) {
                System.out.println("Slide deleted. The presentation is blank. Create a new slide");
                size--;
                return;
            }
            head.prev = null;
            size--;
            System.out.println("Slide deleted");
            showMenu();
            return;
        }

        if (index == size) { // deletes the last slide
            Node secondLast = getIndex(size - 2);
            tail = secondLast;
            tail.next = null;
            tail.prev = secondLast.prev;
            size--;
            System.out.println("Slide deleted");
            showMenu();
            return;
        }

        if (index > size) {
            System.out.println("Error: There is no such slide");
            showMenu();
            return;
        }

            Node pointer = getIndex(index - 1); // deletes the slides in between the first and last slide
            pointer.next = pointer.next.next;
            pointer.next.prev = pointer;
            size--;
            System.out.println("Slide deleted");
            showMenu();

    }

    public void insertAtFirstSlide() {
        slideContent.clear();
        slideGenerator();
        Node newNode = new Node(new ArrayList<>(slideContent));
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = null;
        head = newNode;
        size++;
    }

    @Override
    public void insertAfterIndex(int index) {
        Node currentNode = getIndex(index);

        if (currentNode == null) {
            createSlides();
            return;
        }

        if (index == size) {
            createSlides();
        }

        Node nextNode = getIndex(index+1);

        slideContent.clear();
        slideGenerator();
        Node newNode = new Node(new ArrayList<>(slideContent));
        currentNode.next = newNode;
        newNode.next = nextNode;
        if (nextNode != null) {
            nextNode.prev = newNode;
        }
        newNode.prev = currentNode;
        size++;
        showMenu();
    }

    @Override
    public void insertBeforeIndex(int index) {
        Node currentNode = getIndex(index);

        if (currentNode == null) {
            createSlides();
            return;
        }

        if (index == 0) {
            insertAtFirstSlide();
            showMenu();
            return;
        }


        Node prevNode = getIndex(index-1);

        slideContent.clear();
        slideGenerator();
        Node newNode = new Node(new ArrayList<>(slideContent));
        prevNode.next = newNode;
        newNode.prev = prevNode;
        currentNode.prev = newNode;
        newNode.next = currentNode;
        size++;
    }

    public Node getIndex(int index) { // Gets/returns the index of a specific node
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

}
