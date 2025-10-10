package Exercicio_2;

import Exercicio_1.QueueADT;

public class CircularArrayQueue<T> implements QueueADT<T> {
    private final static int DEFAULT_CAPACITY = 5;
    private int front, rear, count;
    private T[] queue;

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }

    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;

        rear = (rear + 1) % queue.length;

        count++;
    }

    @Override
    public T dequeue() /*throws EmptyCollectionException*/ {
        /*if (isEmpty()) {
            throw new EmptyCollectionException("Empty queue");
        }*/
        T result = queue[front];

        queue[front] = null;

        front = (front + 1) % queue.length;

        count--;

        return result;
    }

    @Override
    public T first() /*throws EmptyCollectionException*/ {
        /*if (isEmpty()) {
            throw new EmptyCollectionException("Empty queue");
        }*/
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < count; i++) {
            sb.append(queue[(front + i) % queue.length]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);
        for (int i = 0; i < count; i++) {
            larger[i] = queue[(front + i) % queue.length];
        }
        front = 0;
        rear = count;
        queue = larger;
    }
}
