package struct.impl;

import struct.istruct.Queue;

/**
 * DynamicQueue is an implementation of a Queue, a data structure based on a First-In-First-Out criteria.
 *
 * This implementation is based on linked Nodes.
 *
 * @param <Q> the data type to be stored
 *
 * @author Manuel Pedrozo
 * @author Tomas Perez Molina
 */
public class DynamicQueue<Q> implements Queue<Q>{
    private class Node<Q> {
        private Q data;
        private Node<Q> next;

        private Node(Q data) {
            this.data = data;
        }
    }

    private Node<Q> front, back;
    private int size;

    public DynamicQueue(){
        empty();
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element element to be added.
     */
    @Override
    public void enqueue(Q element) {
        if(isEmpty()){
            front = new Node<>(element);
            back = front;
        }
        else{
            back.next = new Node<>(element);
            back = back.next;
        }
        size++;
    }

    /**
     * Removes and returns the front(first) element of the queue.
     *
     * @return the first element of the queue.
     */
    @Override
    public Q dequeue() {
        if(isEmpty())
            return null;
        Q aux = front.data;
        front = front.next;
        size--;
        return aux;
    }

    /**
     *
     * @return true if the queue is empty, false if not.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @return the length of the queue.
     */
    @Override
    public int length() {
        return size;
    }

    /**
     *
     * @return the amount of elements in the queue.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Empties(resets) the queue.
     */
    @Override
    public void empty() {
        front = null;
        back = null;
        size = 0;
    }
}
