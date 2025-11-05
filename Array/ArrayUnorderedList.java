package Exercicio_3;

import Exceptions.ELementNullException;
import Exceptions.NotFindElement;
import Exercicio_1.ArrayList;

/**
 * Implements an unordered list using a resizable array.
 * This class allows elements to be added to the front, rear,
 * or after a specific target element.
 *
 * @param <T> the type of elements stored in the list
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {

    /**
     * Creates an empty unordered list with the default capacity.
     */
    public ArrayUnorderedList() {
        super();
    }

    /**
     * Creates an empty unordered list with the specified initial capacity.
     *
     * @param initialCapacity the initial size of the internal array.
     */
    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the front
     * @throws ELementNullException if the specified element is null
     */
    @Override
    public void addToFront(T element) {

        if (size == list.length) {
            expandCapacity();
        }

        if (element == null) {
            throw new ELementNullException();
        }

        // Shift all elements one position to the right
        for (int j = size; j > 0; j--) {
            list[j] = list[j - 1];
        }

        list[0] = element;
        size++;
        modCount++;
    }

    /**
     * Adds the specified element to the rear (end) of this list.
     *
     * @param element the element to be added to the rear
     * @throws ELementNullException if the specified element is null
     */
    @Override
    public void addToRear(T element) {

        if (size == list.length) {
            expandCapacity();
        }

        if (element == null) {
            throw new ELementNullException();
        }

        // Add to the end and increment size
        list[size++] = element;
        modCount++;
    }

    /**
     * Adds the specified element *after* a given target element.
     *
     * @param element the element to be added
     * @param target  the element after which to insert the new element
     * @throws ELementNullException if the element to add is null
     * @throws NotFindElement       if the target element is not found in the list
     */
    @Override
    public void addAfter(T element, T target) {

        if (size == list.length) {
            expandCapacity();
        }


        if (element == null) {
            throw new ELementNullException();
        }


        int indexT = find(target);


        if (indexT == -1) {
            throw new NotFindElement();
        }

        for (int j = size; j > indexT + 1; j--) {
            list[j] = list[j - 1];
        }

        list[indexT + 1] = element;
        size++;
        modCount++;
    }
}