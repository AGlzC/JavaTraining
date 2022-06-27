package com.training.collections.set.treeset;

public class GenericNodeStack<T>{
    T data;
    GenericNodeStack<T> next;

    GenericNodeStack(T data, GenericNodeStack<T>next){
        this.data = data;
        this.next = next;
    }
}
