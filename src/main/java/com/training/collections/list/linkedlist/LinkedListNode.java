package com.training.collections.list.linkedlist;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    LinkedListNode<T> previous;

    LinkedListNode(T data, LinkedListNode<T> next, LinkedListNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

}
