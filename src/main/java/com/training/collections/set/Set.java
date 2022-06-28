package com.training.collections.set;

import com.training.collections.Iterator;

public interface Set<T> {
    void add(T data);

    void remove(T data);

    void removeAll();

    int size();

    boolean contains(T data);

    Iterator iterator();

    Iterator reverseIterator();

}
