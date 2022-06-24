package com.training.collections.list.genericlinkedlist;

import com.training.collections.list.GenericIterator;
import com.training.collections.list.GenericList;


public class GenericLinkedList<T> implements GenericList<T> {
    private GenericNode<T> head;
    private GenericNode<T> tail;
    private int currentSize;

    public void add(T data) {
        GenericNode<T> current = new GenericNode<>(data, null, tail);
        if (head == null) {
            head = current;
        }
        else {
            tail.next = current;
        }

        tail = current;
        currentSize ++;
    }

    public void insert(int index, T data) {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == currentSize) {
            add(data);
        }
        else {
            GenericNode<T> temporal = getNodeAt(index- 1);
            GenericNode<T> current = new GenericNode<>(data, temporal.next, temporal);
            temporal.next.previous = current;
            temporal.next = current;
            currentSize++;
        }
    }

    public T getAt(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            return head.data;
        }
        else if (index == currentSize - 1) {
            return tail.data;
        }
        return getNodeAt(index).data;
    }

    public void setAt(int index, T data) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            head.data = data;
        }
        else if (index == currentSize - 1) {
            tail.data = data;
        }
        else {
            getNodeAt(index).data = data;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException(index);
        }

        GenericNode<T> temporal;
        if (index == 0) {
            temporal = head;
            head = temporal.next;
            if (head != null) {
                head.previous = null;
            }
        }
        else if (index == currentSize - 1) {
            temporal = tail;
            tail = temporal.previous;
            tail.next = null;
        }
        else {
            temporal = getNodeAt(index);
            temporal.previous.next = temporal.next;
            temporal.next.previous = temporal.previous;
        }
        currentSize --;
    }

    public void removeAll() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    public int size()
    {
        return currentSize;
    }


    public boolean contains(T data) {
        GenericNode<T> temporal = head;
        while (temporal != null) {
            if (temporal.data.equals(data)) {
                return true;
            }
            temporal = temporal.next;
        }
        return false;
    }

    public int indexOf(T data) {
        int index = 0;
        GenericNode<T> temporal = head;
        while (temporal != null) {
            if (temporal.data.equals(data)) {
                return index;
            }
            temporal = temporal.next;
            index ++;
        }
        return -1;
    }

    public GenericIterator<T> iterator() {
        return new GenericIterator<>() {
            private GenericNode<T> currentNode = head;

            @Override
            public T next() {
                T data = null;
                if (currentNode != null) {
                    data = currentNode.data;
                    currentNode = currentNode.next;
                }
                return data;
            }

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }
        };
    }

    @Override
    public GenericIterator<T> reverseIterator() {
        return new GenericIterator<>() {
            private GenericNode<T> currentNode = tail;

            @Override
            public T next() {
                T data = null;
                if (currentNode != null) {
                    data = currentNode.data;
                    currentNode = currentNode.previous;
                }
                return data;
            }

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }
        };
    }

    private GenericNode<T> getNodeAt(int index) {
        GenericNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

}
