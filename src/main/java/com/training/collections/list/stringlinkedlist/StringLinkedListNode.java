package com.training.collections.list.stringlinkedlist;

class StringLinkedListNode {
    String data;
    StringLinkedListNode next;
    StringLinkedListNode previous;

    StringLinkedListNode(String data, StringLinkedListNode next, StringLinkedListNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

}
