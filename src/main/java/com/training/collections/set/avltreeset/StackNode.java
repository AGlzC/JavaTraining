package com.training.collections.set.avltreeset;

class StackNode<T>{
    T data;
    StackNode<T> next;

    StackNode(T data, StackNode<T> next){
        this.data = data;
        this.next = next;
    }
}
