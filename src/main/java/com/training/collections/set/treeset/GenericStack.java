package com.training.collections.set.treeset;

public class GenericStack<T> {
    private GenericNodeStack<T> head;

    public T pop() {
        if (head != null) {
            T returnData = head.data;
            head = head.next;
            return returnData;
        }
        return null;
    }

    public void push(T data){
        head = new GenericNodeStack<>(data, head);
    }

    public boolean empty() {
        return head == null;
    }
}
