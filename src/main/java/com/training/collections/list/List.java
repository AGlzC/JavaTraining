package com.training.collections.list;

import com.training.collections.list.linkedlist.LinkedList;

public interface List {
    void add(String data);

    void insert(int index, String data);

    String getAt(int index);

    void setAt(int index, String data);

    void remove(int index);

    void removeAll();

    int size();

    boolean contains(String data);

    int indexOf(String data);

    Iterator iterator();

    Iterator reverseIterator();

}
