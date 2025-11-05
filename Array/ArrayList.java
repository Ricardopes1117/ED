package Exercicio_1;

import Exceptions.*;

import java.util.Iterator;

/**
 * An abstract base class for implementing a list using a resizable array.
 * This class provides the core storage, size management, and common operations.
 *
 * @param <T> the type of elements stored in the list
 */
public abstract class ArrayList<T> implements ListADT<T> {

    private final static int DEFAULT_CAPACITY = 20;
    private final int INCREMENT = 2;

    protected Object[] list;
    protected int size;

    protected int modCount;

    /**
     * Creates an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial size of the internal array.
     */
    public ArrayList(int initialCapacity) {
        list = new Object[initialCapacity];
        size = 0;
    }

    /**
     * Creates an empty list with the default capacity.
     */
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element removed from the list
     * @throws ListEmpetyException if the list is empty
     */
    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new ListEmpetyException();
        }
        T result = (T) list[0];
        for (int i = 0; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        this.list[--this.size] = null;

        this.modCount++;

        return result;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element removed from the list
     * @throws ListEmpetyException if the list is empty
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            throw new ListEmpetyException();
        }
        T result = (T) list[size - 1];

        this.list[--this.size] = null;

        this.modCount++;

        return result;
    }


    /**
     * Removes and returns the first occurrence of the specified element from this list.
     *
     * @param element the element to be removed
     * @return the element that was removed
     * @throws ListEmpetyException if the list is empty
     * @throws NotFindElement      if the specified element is not found
     */
    @Override
    public T remove(T element) {
        if (isEmpty()) {
            throw new ListEmpetyException();
        }

        int index = this.find(element);

        if (index == -1) {
            throw new NotFindElement();
        }

        T remove = (T) this.list[index];

        for (int i = index; i < this.size - 1; i++) {
            list[i] = list[i + 1];
        }

        this.list[--this.size] = null;

        this.modCount++;

        return remove;
    }

    /**
     * Returns (without removing) the first element of this list.
     *
     * @return the first element in the list
     * @throws ListEmpetyException if the list is empty
     */
    @Override
    public T first() {
        if (isEmpty()) {
            throw new ListEmpetyException();
        }
        return (T) this.list[0];
    }

    /**
     * Returns (without removing) the last element of this list.
     *
     * @return the last element in the list
     * @throws ListEmpetyException if the list is empty
     */
    @Override
    public T last() {
        if (isEmpty()) {
            throw new ListEmpetyException();
        }
        return (T) this.list[size - 1];
    }

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the element to search for
     * @return true if the element is found, false otherwise
     * @throws ListEmpetyException if the list is empty (as per original logic)
     */
    @Override
    public boolean contains(T target) {
        if (isEmpty()) {
            throw new ListEmpetyException();
        }
        return find(target) != -1;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer number of elements in the list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an Iterator instance
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string in the format [element1, element2, ...]
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(list[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Creates a new array to store the contents of the list with an
     * expanded capacity (multiplied by the INCREMENT factor).
     */
    public void expandCapacity() {
        Object[] newList = new Object[this.list.length * INCREMENT];
        if (size >= 0) System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }

    /**
     * Searches for the first occurrence of the specified element.
     *
     * @param element the element to find
     * @return the index of the element if found, or -1 if not found
     */
    protected int find(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (list[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(list[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * An inner class to provide fail-fast iterator functionality.
     */
    protected class MyIterator<E> implements Iterator<E> {

        private int ExpetedModcount;
        private int Current;
        private boolean okToRemove;

        /**
         * Constructs a new iterator, saving the list's current modification count.
         */
        protected MyIterator() {
            this.ExpetedModcount = modCount;
            this.okToRemove = false;
            this.Current = 0;

        }

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if there are more elements, false otherwise
         * @throws ExpectedModcountDifModcountException if the list is modified concurrently
         */
        @Override
        public boolean hasNext() {
            if (this.ExpetedModcount != modCount) {
                throw new ExpectedModcountDifModcountException(); //lança uma exception de haver alterações depois de criar o iterator
            }
            return Current < size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element
         * @throws NotHasNextException                  if there are no more elements
         * @throws ExpectedModcountDifModcountException if the list is modified concurrently
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NotHasNextException();
            }

            okToRemove = true;

            return (E) list[Current++];
        }

        /**
         * Removes from the underlying collection the last element returned by this iterator.
         *
         * @throws ExpectedModcountDifModcountException if the list is modified concurrently
         * @throws ElementNotOkToRemove                 if next() has not been called or remove() has already been called
         */
        @Override
        public void remove() {
            if (this.ExpetedModcount != modCount) {
                throw new ExpectedModcountDifModcountException();
            }

            if (!okToRemove) {
                throw new ElementNotOkToRemove();
            }

            ArrayList.this.remove((T) list[Current - 1]);
            ExpetedModcount++;
            okToRemove = false;
        }
    }
}