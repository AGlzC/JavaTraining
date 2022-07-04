package com.training.collections.set.linkedhashset;

import com.training.collections.Iterator;
import com.training.collections.list.linkedlist.LinkedList;
import com.training.collections.set.hashset.HashSet;

public class LinkedHashSet<T> extends HashSet<T> {
    private final LinkedList<T> linkedList;


    public LinkedHashSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(T data) {
        super.add(data);
        linkedList.add(data);
    }

    @Override
    public void remove(T data) {
        super.remove(data);
        int index = linkedList.indexOf(data);
        if (index != -1) {
            linkedList.remove(index);
        }
    }

    @Override
    public void removeAll() {
        super.removeAll();
        linkedList.removeAll();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean contains(T data) {
        return super.contains(data);
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }

    @Override
    public Iterator<T> reverseIterator() {
        return linkedList.reverseIterator();
    }
}
