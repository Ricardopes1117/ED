package Exercicio_2;

import Exceptions.*;
import Exercicio_1.ListADT;

import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

    protected DoubleNode<T> head;
    protected DoubleNode<T> tail;
    protected int size;
    protected int modCount;

    /**
     * F
     * Constructor DoubleLinkedList
     */
    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
        modCount = 0;
    }

    /**
     * Find is an additional function that is used to search for an element T in the List
     *
     * @param element we want to look for
     * @return true if the element is in the list
     */
    protected boolean find(T element) {
        DoubleNode<T> current = head;
        while (current != null) {
            if (element.equals(current.getElement())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * function used to remove the first element in the list
     * checks if the list is not empty
     *
     * @return Element to remove
     */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new ListEmpetyException();
        }
        DoubleNode<T> current = head;

        if (this.size == 1) {
            head = null;
            tail = null;
        }

        head = head.getNext();
        head.setPrv(null);

        this.size--;
        this.modCount++;
        return current.getElement();
    }

    /**
     * Function used to remove the last element in the list
     * checks if the list is not empty
     *
     * @return ELement to remove
     */
    @Override
    public T removeLast() {
        DoubleNode<T> current = tail;
        if (isEmpty()) {
            throw new ListEmpetyException();
        }
        if (this.size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrv();
            tail.setNext(null);
        }
        this.size--;
        this.modCount++;
        return current.getElement();
    }

    /**
     * Function used to remove an element that is passed as a
     * parameter to remove from our list, for this we use the find function to make it easier
     *
     * @param element is the element of the list that we want to remove
     * @return the element
     */
    @Override
    public T remove(T element) {
        DoubleNode<T> current = head;
        DoubleNode<T> previous = null;
        boolean find = false;

        if (isEmpty()) {
            throw new ListEmpetyException();
        }

        while (current != null && !find) {
            if (element.equals(current.getElement())) {
                find = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (!find) {
            throw new NotFindElement();
        }

        if (this.size == 1) {
            head = tail = null;
        } else if (current == head) {
            head = head.getNext();
            head.setPrv(null);
        } else if (current == tail) {
            tail = previous;
            tail.setNext(null);
        } else {
            previous.setNext(current.getNext());
            current.getNext().setPrv(previous);
        }
        this.modCount++;
        return current.getElement();
    }

    /**
     * Function used for check a first element in the list
     *
     * @return the first element the list
     */
    @Override
    public T first() {
        DoubleNode<T> current = head;
        if (current == null) {
            throw new ELementNullException();
        }
        return current.getElement();
    }

    /**
     * Function used for check a last element in the list
     *
     * @return the last element in the list
     */
    @Override
    public T last() {
        DoubleNode<T> current = tail;
        if (current == null) {
            throw new ELementNullException();
        }
        return current.getElement();
    }

    /**
     * function used to check if the target passed in the parameter
     * exists in the list
     *
     * @param target is the element we want to see if it exists in the list
     * @return true if contains
     */
    @Override
    public boolean contains(T target) {
        if (target == null) {
            throw new ELementNullException();
        }
        return find(target);
    }

    /**
     * Function used for verify if the list is empty
     *
     * @return True if is empty
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Function used for check a size of the list
     *
     * @return List size
     */
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        DoubleNode<T> current = head;
        while (current != null) {
            sb.append(current.getElement());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Function used for create the Iterator for my list / collecion
     *
     * @return Intern Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }

    /*
     *  Class inner MyIterator  for the Iterator to have access to our collection
     * so as not to make our collection known to other classes, for this we created
     * this class and implemented Iterator
     */
    private class MyIterator<E> implements Iterator<E> {

        private int ExpetedModcount;
        private DoubleNode<T> Current;
        private boolean okToRemove;
        private T ElementToRemove;

        private MyIterator() {
            this.ExpetedModcount = modCount;
            this.okToRemove = false;
            this.Current = (DoubleNode<T>) head;

        }

        @Override
        public boolean hasNext() {
            if (ExpetedModcount != modCount) {
                throw new ExpectedModcountDifModcountException();
            }
            return Current != null;
        }

        @Override
        public E next() {
            if (Current == null) {
                throw new ELementNullException();
            }

            ElementToRemove = Current.getElement();
            Current = Current.getNext();

            okToRemove = true;
            return (E) ElementToRemove;
        }

        @Override
        public void remove() {

            if (this.ExpetedModcount != modCount) {
                throw new ExpectedModcountDifModcountException();
            }

            if (!okToRemove) {
                throw new ElementNotOkToRemove();
            }

            DoubleLinkedList.this.remove(ElementToRemove);
            modCount++;
            ExpetedModcount = modCount;
            okToRemove = false;

        }
    }
}


