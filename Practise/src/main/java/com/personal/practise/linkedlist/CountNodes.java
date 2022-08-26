package com.personal.practise.linkedlist;

public class CountNodes {
    public static int getCount(Node head) {
        int count=0;
        while ( head.next!=null ){
            count ++;
            head = head.next;
        }
        return count;
    }
}
