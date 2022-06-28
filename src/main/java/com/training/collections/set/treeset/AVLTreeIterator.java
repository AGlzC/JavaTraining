package com.training.collections.set.treeset;

import com.training.collections.Iterator;

class AVLTreeIterator<T> implements Iterator<T> {
    Stack<AVLTreeNode<T>> stack = new Stack<>();
    boolean reversed;

    AVLTreeIterator(AVLTreeNode<T> node, boolean reversed){
        this.reversed = reversed;
        pushNodes(node);
    }

    private void pushNodes(AVLTreeNode<T> node)
    {
        AVLTreeNode<T> temporal = node;
        while (temporal != null) {
            stack.push(temporal);
            if (reversed) {
                temporal = temporal.right;
            }
            else {
                temporal = temporal.left;
            }
        }
    }

    @Override
    public T next() {
        AVLTreeNode<T> node = stack.pop();
        if (reversed){
            pushNodes(node.left);
        }
        else {
            pushNodes(node.right);
        }
        return node.data;
    }

    @Override
    public boolean hasNext() {
        return !stack.empty();
    }
}