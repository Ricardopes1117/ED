package Exercicio_1_Parte2;

public interface StackADT<T> {

    /**
     * Pushes an element onto the top of the stack.
     */
    void push(T element);

    /**
     * Removes and returns the top element of the stack.
     */
    T pop();

    /**
     * Returns the top element of the stack without removing it.
     */
    T peek();

    /**
     * Checks if the stack is empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     */
    int size();
}
