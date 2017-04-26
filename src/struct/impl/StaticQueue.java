package struct.impl;

import struct.istruct.Queue;

/**
 * StaticQueue is an implementation of a Queue, a data structure based on a First-In-First-Out criteria.
 *
 * This implementation is based on an array.
 *
 * @param <Q> the data type to be stored.
 *
 * @author Manuel Pedrozo
 * @author Tomas Perez Molina
 */
public class StaticQueue<Q> implements Queue<Q>{

    private Object[] queue;
    private int front, back, size;

    public StaticQueue(int length){
        queue = new Object[length];
        empty();
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element element to be added.
     */
    public void enqueue(Q element){
        if(size == queue.length){
            grow();
        }
        queue[back] = element;
        back = increment(back);
        size++;
    }

    /**
     * Removes and returns the front(first) element of the queue.
     *
     * @return the first element of the queue.
     */
    public Q dequeue(){
        if(isEmpty()){
            return null;
        }
        Q element = (Q) queue[front];
        front = increment(front);
        size--;
        return element;
    }

    private int increment(int i){
        if(i == queue.length - 1)
            return 0;
        return i+1;
    }

    /**
     *
     * @return true if the queue is empty, false if not.
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     *
     * @return the length of the queue.
     */
    public int length(){
        return queue.length;
    }

    /**
     *
     * @return the amount of elements in the queue.
     */
    public int size() {
        return size;
    }

    private void grow(){
        Object[] aux = new Object[length() * 2];
        for(int i = 0; i < length(); i++)
            aux[i] = dequeue();
        size = queue.length;
        queue = aux;
        back = size;
        front = 0;
    }

    /**
     * Empties(resets) the queue.
     */
    public void empty(){
        front = 0;
        back = 0;
        size = 0;
    }
}
