package com.personal.practise.linkedlist;

public class StackUsingLinkedList {
    Node top;

    void push(int a) {
        Node temp = new Node(a);
        temp.next = top;
        top = temp;
    }

    int pop() {
        int poppedData = -1;
        if(top == null)
            return poppedData;
        else{
            poppedData = top.data;
            Node temp = top;
            top = top.next;
            temp = null;
        }
        return poppedData;
    }

}
