package com.personal.practise.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfLinkedLists {

    public static Node findIntersection(Node head1, Node head2)
    {
        Node headNode = null, head = null;
        HashSet<Integer> set = new HashSet<>();
        while (head2 !=null) {
            set.add(head2.data);
            head2 = head2.next;
        }

        while (head1 != null){
            if(set.contains(head1.data)){
                Node newNode = new Node(head1.data);
                if(headNode == null) {
                    head = headNode = newNode;
                } else {
                    head.next = newNode;
                    head = newNode;
                }
            }
            head1 = head1.next;
        }
        return headNode;
    }
}
