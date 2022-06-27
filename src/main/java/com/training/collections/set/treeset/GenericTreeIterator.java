package com.training.collections.set.treeset;

import com.training.collections.list.GenericIterator;

public class GenericTreeIterator<T> implements GenericIterator<T> {
    GenericStack<GenericTreeNode<T>> stack = new GenericStack<>();
    boolean reversed;

    GenericTreeIterator(GenericTreeNode<T> node, boolean reversed){
        this.reversed = reversed;
        pushNodes(node);
    }

    private void pushNodes(GenericTreeNode<T> node)
    {
        GenericTreeNode<T> temporal = node;
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
        GenericTreeNode<T> node = stack.pop();
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