package com.training.collections.set.avltreeset;

class AVLTreeNode<T> {
    int height;
    T data;
    AVLTreeNode<T> left;
    AVLTreeNode<T> right;

    AVLTreeNode(T data) {
        height = 1;
        this.data = data;
    }

}
