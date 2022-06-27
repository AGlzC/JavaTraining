package com.training.collections.set.treeset;

public class GenericTreeNode<T> {
    int height;
    T data;
    GenericTreeNode<T> left;
    GenericTreeNode<T> right;

    GenericTreeNode(T data) {
        height = 1;
        this.data = data;
    }

}
