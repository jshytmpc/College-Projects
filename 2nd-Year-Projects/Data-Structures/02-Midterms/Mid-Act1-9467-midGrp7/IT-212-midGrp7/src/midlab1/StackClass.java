package midlab1;

import java.util.ArrayList;

public class StackClass<E> implements MyStack<E> {
    ArrayList<E> aL;
    int top = -1;
    int size;

    StackClass(int x) {
        aL = new ArrayList<>(x);
        size = x;
    }

    @Override
    public void push(E x) {
        if (isFull()) {
            System.out.println("stack is full, cannot push");
            return;
        }

        aL.add(x);
        top++;
    }

    @Override
    public E pop() {

        if (isEmpty()) {
            System.out.println("stack is empty, cannot pop");
            return null;
        }

        E tope = aL.get(top);
        aL.remove(top);
        top--;
        return tope;
    }

    @Override
    public boolean isFull() {
        if (top + 1 == size)
            return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (top == -1)
            return true;
        return false;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.out.println("stack is empty, no top");
            return null;
        }
        return aL.get(top);
    }

    @Override
    public String printStack() {
        String stacc = "";
        for (E s : aL)
            stacc += s;
        return stacc;
    }
}