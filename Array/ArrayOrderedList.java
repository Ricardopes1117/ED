package Exercicio_1;

import Exceptions.*;

/**
 * Implements an ordered list using a resizable array.
 * Elements are stored in ascending order based on their natural
 * (Comparable) ordering. This class ensures that all elements
 * added are kept sorted.
 *
 * @param <T> the type of elements stored in the list, which must
 *            implement the Comparable interface.
 */
public class ArrayOrderedList<T extends Comparable<? super T>> extends ArrayList<T> implements OrderedListADT<T> {

    /**
     * Creates an empty ordered list with the default initial capacity.
     */
    public ArrayOrderedList() {
        super();
    }

    /**
     * Creates an empty ordered list with the specified initial capacity.
     *
     * @param initialCapacity the initial size of the internal array.
     */
    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Adds the specified element to this list, maintaining sorted order.
     * The element is inserted at the correct position to keep the list
     * sorted.
     *
     * @param element the element to be added to the list
     * @throws ELementNullException if the specified element is null
     */
    @Override
    public void add(T element) {
        if (element == null) {
            throw new ELementNullException();
        }


        if (size == list.length) {
            expandCapacity();
        }

        int i = 0;


        while (i < size && element.compareTo((T) list[i]) > 0) {
            i++;
        }

        for (int j = size; j > i; j--) {
            list[j] = list[j - 1];
        }


        list[i] = element;
        size++;
        modCount++;
    }
}