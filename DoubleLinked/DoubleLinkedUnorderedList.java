package Exercicio_4;

import Exceptions.*;
import Exercicio_2.DoubleLinkedList;
import Exercicio_2.DoubleNode;
import Exercicio_3.UnorderedListADT;

/**
 * Implements an unordered list using a doubly linked structure.
 * This class allows elements to be added to the front, rear,
 * or after a specific target element.
 *
 * @param <T> the type of elements stored in the list
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    /**
     * Creates an empty unordered list.
     */
    public DoubleLinkedUnorderedList() {
        super();
    }

    /**
     * Helper method to safely find the first node containing the target element.
     * This method correctly handles searching for null targets or
     * searching in lists that contain null elements.
     *
     * @param target the element to search for
     * @return the DoubleNode containing the target, or null if not found
     */
    private DoubleNode<T> findNode(T target) {
        DoubleNode<T> current = head;

        if (target == null) {

            while (current != null) {
                if (current.getElement() == null) {
                    return current;
                }
                current = current.getNext();
            }
        } else {

            while (current != null) {
                if (target.equals(current.getElement())) {
                    return current;
                }
                current = current.getNext();
            }
        }

        return null;
    }

    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the front
     * @throws ELementNullException if the specified element is null
     */
    @Override
    public void addToFront(T element) {
        if (element == null) {
            throw new ELementNullException();
        }

        DoubleNode<T> newNode = new DoubleNode<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrv(newNode);
            head = newNode;
        }
        this.size++;
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
        if (element == null) {
            throw new ELementNullException();
        }

        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrv(tail);
            tail = newNode;
        }

        this.size++;
        modCount++;
    }

    /**
     * Adds the specified element *after* a given target element.
     *
     * @param element the element to be added
     * @param target  the element after which to insert the new element
     * @throws ELementNullException if the element to add is null
     * @throws HeadNullException    if the list is empty
     * @throws NodeNullException    if the target element is not found
     */
    @Override
    public void addAfter(T element, T target) {
        if (element == null) {
            throw new ELementNullException();
        }

        if (head == null) {
            throw new HeadNullException();
        }

        DoubleNode<T> current = findNode(target);

        if (current == null) {
            throw new NodeNullException();
        }

        DoubleNode<T> newNode = new DoubleNode<>(element);
        newNode.setPrv(current);
        newNode.setNext(current.getNext());

        if (current.getNext() != null) {
            current.getNext().setPrv(newNode);
        } else {
            tail = newNode;
        }

        current.setNext(newNode);
        this.size++;
        modCount++;
    }
}