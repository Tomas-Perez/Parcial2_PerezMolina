package struct.impl;

import struct.impl.Exceptions.ObjectAlreadyInTreeException;
import struct.impl.Exceptions.ObjectNotFoundException;
import struct.istruct.BinaryTree;

import java.lang.Comparable;

/**
 * SearchBinaryTree is an implementation of a search binary tree that is based on a ordered binary
 * tree.
 * @param <T> data type to be stored, needs to extend Comparable.
 */
public class SearchBinaryTree <T extends Comparable<T>> implements BinaryTree<T>{

    private class DoubleNode<T>{
        T element;
        DoubleNode<T> left, right;

        public DoubleNode(){}

        public DoubleNode(T element) {
            this.element = element;
        }

        public DoubleNode(T element, DoubleNode<T> left, DoubleNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private DoubleNode<T> root;

    public SearchBinaryTree(){root = null;}

    public SearchBinaryTree(T root){
        this.root = new DoubleNode<>(root);
    }

    public SearchBinaryTree(T root, SearchBinaryTree<T> left, SearchBinaryTree<T> right){
        this.root = new DoubleNode(root,left.root,right.root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public SearchBinaryTree<T> getLeft(){
        SearchBinaryTree<T> b = new SearchBinaryTree<T>();
        b.root = root.left;
        return b;
    }

    public SearchBinaryTree<T> getRight(){
        SearchBinaryTree<T> b = new SearchBinaryTree<>();
        b.root = root.right;
        return b;
    }

    public T getRoot(){
        return root.element;
    }

    /**
     * Checks if the received object exists in the tree.
     * @param obj object to be checked.
     * @return true if the object is found.
     */
    public boolean exists(T obj){
        return existsAux(obj,root);
    }

    private boolean existsAux(T obj, DoubleNode<T> node){
        if(node == null)
            return false;
        if(node.element.compareTo(obj) == 0)
            return true;
        else if(node.element.compareTo(obj) < 0)
            return existsAux(obj,node.right);
        return existsAux(obj,node.left);
    }

    /**
     * @return element with the minimum value.
     */
    public T getMin(){
        return getMin(root);
    }

    private T getMin(DoubleNode<T> node){
        if(node.left == null)
            return node.element;
        return getMin(node.left);
    }

    /**
     * @return element with the maximum value.
     */
    public T getMax(){
        return getMax(root);
    }

    private T getMax(DoubleNode<T> node){
        if(node.right == null)
            return node.element;
        return getMax(node.right);
    }

    /**
     * Searches for the received object in the tree.
     * Throws an ObjectNotFoundException if the object is not found.
     * @param obj object to be searched for.
     * @return found object.
     */
    public T search(T obj){
        return search(obj,root);
    }

    private T search(T obj, DoubleNode<T> node){
        if(node == null)
            throw new ObjectNotFoundException();
        if(node.element.compareTo(obj) == 0)
            return node.element;
        else if(node.element.compareTo(obj) < 0)
            return search(obj,node.right);
        return search(obj,node.left);
    }

    /**
     * Inserts the received object into the tree respecting the order.
     * @param obj object to be inserted.
     */
    public void insert(T obj){
        root = insert(obj,root);
    }

    private DoubleNode<T> insert(T obj, DoubleNode<T> node){
        if(node == null) {
            node = new DoubleNode<>();
            node.element = obj;
        }
        else if(node.element.compareTo(obj) == 0)
            throw new ObjectAlreadyInTreeException();
        else if(node.element.compareTo(obj) < 0)
            node.right = insert(obj,node.right);
        else node.left = insert(obj,node.left);
        return node;
    }

    /**
     * Deletes the received object from the tree.
     * Throws an ObjectNotFoundException if the object is not in
     * the tree.
     * @param obj object to be deleted from the tree.
     */
    public void delete(T obj){
        root = delete(obj, root);
    }

    private DoubleNode<T> delete(T obj, DoubleNode<T> node){
        if(node == null)
            throw new ObjectNotFoundException();
        if(node.element.compareTo(obj) > 0)
            node.left = delete(obj,node.left);
        else if(node.element.compareTo(obj) < 0)
            node.right = delete(obj,node.right);
        else{
            if(node.left != null && node.right != null){
                node.element = getMin(node.right);
                node.right = deleteMin(node.right);
            }
            else if(node.left != null){
                node = node.left;
            }
            else
                node = node.right;
        }
        return node;
    }

    private DoubleNode<T> deleteMin(DoubleNode<T> node){
        if(node.left != null)
            node.left = deleteMin(node.left);
        else
            node = node.right;
        return node;
    }
}
