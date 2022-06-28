package com.training.collections.set.avltreeset;

class Stack<T> {
    private StackNode<T> head;

    public T pop() {
        if (head != null) {
            T returnData = head.data;
            head = head.next;
            return returnData;
        }
        return null;
    }

    public void push(T data){
        head = new StackNode<>(data, head);
    }

    public boolean empty() {
        return head == null;
    }
}
