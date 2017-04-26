package struct.impl;

import java.io.Serializable;

public class BinaryTree <T> implements struct.istruct.BinaryTree, Serializable{

    private DoubleNode<T> root;

    public BinaryTree(){root = null;}

    public BinaryTree(T root){
        this.root = new DoubleNode<>(root);
    }

    public BinaryTree(T root, BinaryTree<T> left, BinaryTree<T> right){
        this.root = new DoubleNode<>(root,left.root,right.root);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public BinaryTree<T> getLeft(){
        BinaryTree<T> b = new BinaryTree();
        b.root = root.left;
        return b;
    }

    public BinaryTree<T> getRight(){
        BinaryTree<T> b = new BinaryTree();
        b.root = root.right;
        return b;
    }

    public T getRoot(){
        return root.element;
    }

    private class DoubleNode<T> implements Serializable{
        T element;
        DoubleNode<T> left, right;

        public DoubleNode(){}

        public DoubleNode(T element) {
            this.element = element;
        }

        public DoubleNode(T element, DoubleNode<T> left, DoubleNode<T> rigth) {
            this.element = element;
            this.left = left;
            this.right = rigth;
        }
    }
}