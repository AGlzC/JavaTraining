package com.training.collections.list.stringlinkedlist;

import com.training.collections.StringIterator;
import com.training.collections.list.StringList;


public class StringLinkedList implements StringList {
    private StringLinkedListNode head;
    private StringLinkedListNode tail;
    private int currentSize;

    public void add(String data) {
        StringLinkedListNode current = new StringLinkedListNode(data, null, tail);
        if (head == null) {
            head = current;
        }
        else {
            tail.next = current;
        }

        tail = current;
        currentSize ++;
    }

    public void insert(int index, String data) {
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == currentSize) {
            add(data);
        }
        else {
            StringLinkedListNode temporal = getNodeAt(index- 1);
            StringLinkedListNode current = new StringLinkedListNode(data, temporal.next, temporal);
            temporal.next.previous = current;
            temporal.next = current;
            currentSize++;
        }
    }

    public String getAt(int index) {
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

    public void setAt(int index, String data) {
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

        StringLinkedListNode temporal;
        if (index == 0) {
            temporal = head;
            head = temporal.next;
            head.previous = null;
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

    public boolean contains(String data) {
        StringLinkedListNode temporal = head;
        while (temporal != null) {
            if (temporal.data.equals(data)) {
                return true;
            }
            temporal = temporal.next;
        }
        return false;
    }

    @Override
    public int indexOf(String data) {
        int index = 0;
        StringLinkedListNode temporal = head;
        while (temporal != null) {
            if (temporal.data.equals(data)) {
                return index;
            }
            temporal = temporal.next;
            index ++;
        }
        return -1;
    }

    public StringIterator iterator() {
        return new StringIterator() {
            private StringLinkedListNode currentNode = head;

            @Override
            public String next() {
                String data = null;
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
    public StringIterator reverseIterator() {
        return new StringIterator() {
            private StringLinkedListNode currentNode = tail;

            @Override
            public String next() {
                String data = null;
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

    private StringLinkedListNode getNodeAt(int index) {
        StringLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

}
