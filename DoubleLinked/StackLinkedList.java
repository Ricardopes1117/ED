package Exercicio_2;

/**
 * A stack implementation using a linked list.
 */
public class StackLinkedList<T> implements StackADT<T> {
    /**
     * The top node of the stack
     */
    private LinearNode<T> top;
    /**
     * The number of elements in the stack
     */
    private int size;

    /**
     * Constructs an empty stack.
     */
    public StackLinkedList() {
        top = null;
        size = 0;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to be pushed onto the stack
     */
    @Override
    public void push(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T result = top.getElement();
        top = top.getNext();
        size--;
        return result;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getElement();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the stack is empty.
     */
    @Override
    public int size() {
        return size;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        LinearNode<T> current = top;
        while(current != null){
            System.out.println(current.getElement());
            current = current.getNext();
        }
        return sb.toString();
    }
}
