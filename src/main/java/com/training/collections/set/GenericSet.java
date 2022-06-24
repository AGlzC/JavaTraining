package com.training.collections.set;

import com.training.collections.list.GenericIterator;

public interface GenericSet<T> {
    void add(T data);

    void remove(T data);

    void removeAll();

    int size();

    boolean contains(T data);

    GenericIterator iterator();

    GenericIterator reverseIterator();

}
