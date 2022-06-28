package com.training.collections.list;

import com.training.collections.Iterator;

public interface List<T> {
    void add(T data);

    void insert(int index, T data);

    T getAt(int index);

    void setAt(int index, T data);

    void remove(int index);

    void removeAll();

    int size();

    boolean contains(T data);

    int indexOf(T data);

    Iterator<T> iterator();

    Iterator<T> reverseIterator();

}
