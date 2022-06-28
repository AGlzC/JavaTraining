package com.training.collections.set.treeset;

class StackNode<T>{
    T data;
    StackNode<T> next;

    StackNode(T data, StackNode<T> next){
        this.data = data;
        this.next = next;
    }
}
