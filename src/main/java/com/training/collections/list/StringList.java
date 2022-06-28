package com.training.collections.list;

import com.training.collections.StringIterator;

public interface StringList {
    void add(String data);

    void insert(int index, String data);

    String getAt(int index);

    void setAt(int index, String data);

    void remove(int index);

    void removeAll();

    int size();

    boolean contains(String data);

    int indexOf(String data);

    StringIterator iterator();

    StringIterator reverseIterator();

}
