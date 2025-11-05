package Exercicio_1;

public class ArrayStack<T> implements StackADT<T>{

    /**
     * Default capacity of the stack
     */
    private final int DEFAULT_CAPACITY = 100;
    /**
     * Index of the top element in the stack
     */
    private int top;
    /**
     * Array to hold the stack elements
     */
    private T[] stack;

    /**
     * Default constructor with default capacity.
     */
    public ArrayStack() {
        top = 0;
        stack = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructor with initial capacity.
     *
     * @param initialCapacity the initial capacity of the stack
     */
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) new Object[initialCapacity];

    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to be added to the stack
     */
    public void push(T element) {
        if (top == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        top--;
        T element = stack[top];
        stack[top] = null;
        return element;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top - 1];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top <= 0;
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return top;

    }

    /**
     * Doubles the capacity of the stack array when it is full.
     */
    private void expandCapacity() {
        T[] StackLarger = (T[]) new Object[stack.length * 2];
        for(int i = 0; i < stack.length; i++){
            StackLarger[i] = stack[i];
        }
        stack = StackLarger;
    }
}
