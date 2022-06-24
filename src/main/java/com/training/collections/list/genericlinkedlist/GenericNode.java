package com.training.collections.list.genericlinkedlist;

class GenericNode<T> {
    T data;
    GenericNode<T> next;
    GenericNode<T> previous;

    GenericNode(T data, GenericNode<T> next, GenericNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

}
