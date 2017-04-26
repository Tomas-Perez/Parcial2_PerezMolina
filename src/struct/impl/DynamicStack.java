package struct.impl;

import struct.istruct.Stack;

/**
 * DynamicStack is an implementation of a Stack, a data structure based on a Last-In-First-Out criteria, that means the
 * last element to enter the DynamicStack, called top, is the first one to leave.
 *
 * This implementation is based on a linked list of nodes.
 *
 * @param <T> the data type to be stored
 *
 * @author Tomas Perez Molina
 * @author Manuel Pedrozo
 */

public class DynamicStack<T> implements Stack<T> {
    private Node<T> head;
    private int size = 0;

    /**
     * Adds an element to the top of the stack.
     *
     * @param t the element to be stored
     */

    @Override
    public void push(T t) {
        Node<T> newHead = new Node<>(t);
        newHead.next = head;
        head = newHead;
        size++;
    }

    /**
     * Removes the top from the stack
     */

    @Override
    public void pop() {
        if(!isEmpty()){
            head = head.next;
            size--;
        }
    }

    /**
     * @return top of the stack
     */

    @Override
    public T peek() {
        return head.data;
    }

    /**
     * @return true if the stack is empty, false if it isn't.
     */

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the size of the stack
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the stack and sets size back to 0.
     */

    @Override
    public void empty() {
        size = 0;
        head = null;
    }

    /**
     * @return string listing the elements in the stack, from top to bottom.
     */

    @Override
    public String toString(){
        String result = "";
        Node<T> node = head;
        if(!isEmpty())
            while(node != null){
                result += node.data.toString() + "\n";
                node = node.next;
            }
        return result;
    }


    /**
     * A Node is the building block for a linked list, it stores data as well as a pointer to the next node in a list.
     * @param <L> the data type to be stored
     */

    private class Node<L> {
        private L data;
        private Node<L> next;

        private Node(L data) {
            this.data = data;
        }
    }

}
