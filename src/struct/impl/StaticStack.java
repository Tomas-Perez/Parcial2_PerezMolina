package struct.impl;

import struct.istruct.Stack;

import java.lang.reflect.Array;

/**
 * StaticStack is an implementation of a Stack, a data structure based on a Last-In-First-Out criteria, that means the
 * last element to enter the StaticStack, called top, is the first one to leave.
 *
 * This implementation is based on an array.
 *
 * @param <T> the data type to be stored
 *
 * @author Tomas Perez Molina
 * @author Manuel Pedrozo
 */

public class StaticStack<T> implements Stack<T>{
    private Object[] data;
    private int top = -1;

    public StaticStack(int initialCapacity){
        data = new Object[initialCapacity];
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param t the element to be stored
     */

    @Override
    public void push(T t) {
        if(top+1 == data.length){
            grow();
        }
        data[++top] = t;
    }

    /**
     * Removes the top from the stack
     */
    @Override
    public void pop() {
        if(!isEmpty()) top--;
    }

    /**
     * @return top of the stack
     */

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) return null;
        return (T) data[top];
    }

    /**
     * @return true if the stack is empty, false if it isn't.
     */

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * @return the size of the stack
     */

    @Override
    public int size() {
        return top+1;
    }

    /**
     * Removes all elements from the stack.
     */

    @Override
    public void empty() {
        top = -1;
    }

    /**
     * Doubles the size of the internal array
     */

    private void grow(){
        Object[] dataAux = new Object[data.length * 2];
        for(int i = 0; i < data.length; i++){
            dataAux[i] = data[i];
        }
        data = dataAux;
    }

    /**
     * @return string listing the elements in the stack, from top to bottom.
     */

    @Override
    public String toString(){
        String result = "";
        if(!isEmpty())
            for(int i = size()-1; i >= 0; i--){
                result += data[i].toString() + "\n";
            }
        return result;
    }

}
