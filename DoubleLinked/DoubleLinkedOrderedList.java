package Exercicio_2;

import Exercicio_1.OrderedListADT;
import Exceptions.*;


public class DoubleLinkedOrderedList<T extends Comparable<? super T>> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    public DoubleLinkedOrderedList() {
        super();
    }

    /**
     * Adds the specified element to the list, maintaining sorted order.
     *
     * @param element the element to add (must not be null)
     * @throws ELementNullException if the element is null
     */
    @Override
    public void add(T element) {


        if (element == null) {
            throw new ELementNullException();
        }


        DoubleNode<T> newNode = new DoubleNode<>(element);

        if (head == null) {
            // Lista vazia
            tail = newNode;
            head = newNode;
        } else {
            DoubleNode<T> current = head;
            while (current != null && current.getElement().compareTo(element) < 0) {
                current = current.getNext();
            }

            if (current == head) {
                newNode.setNext(head);
                head.setPrv(newNode);
                head = newNode;
            } else if (current == null) {
                tail.setNext(newNode);
                newNode.setPrv(tail);
                tail = newNode;
            } else {
                DoubleNode<T> previous = current.getPrv();
                previous.setNext(newNode);
                newNode.setPrv(previous);
                newNode.setNext(current);
                current.setPrv(newNode);
            }
        }

        size++;
        modCount++;
    }
}