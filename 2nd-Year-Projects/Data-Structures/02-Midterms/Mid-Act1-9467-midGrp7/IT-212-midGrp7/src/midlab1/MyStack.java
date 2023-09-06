package midlab1;

public interface MyStack<E> {
    public void push(E x);
    public E pop();
    public boolean isFull();
    public boolean isEmpty();
    public E peek();
    public String printStack();
}
