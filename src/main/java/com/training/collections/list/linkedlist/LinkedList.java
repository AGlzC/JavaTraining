package com.training.collections.list.linkedlist;

import com.training.collections.Iterator;
import com.training.collections.list.List;


public class LinkedList<T> implements List<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int currentSize;

    public void add(T data) {
        LinkedListNode<T> current = new LinkedListNode<>(data, null, tail);
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
            LinkedListNode<T> temporal = getNodeAt(index- 1);
            LinkedListNode<T> current = new LinkedListNode<>(data, temporal.next, temporal);
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

        LinkedListNode<T> temporal;
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
        LinkedListNode<T> temporal = head;
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
        LinkedListNode<T> temporal = head;
        while (temporal != null) {
            if (temporal.data.equals(data)) {
                return index;
            }
            temporal = temporal.next;
            index ++;
        }
        return -1;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private LinkedListNode<T> currentNode = head;

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
    public Iterator<T> reverseIterator() {
        return new Iterator<>() {
            private LinkedListNode<T> currentNode = tail;

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

    private LinkedListNode<T> getNodeAt(int index) {
        LinkedListNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

}
