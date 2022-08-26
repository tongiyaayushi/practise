package com.personal.practise.linkedlist;

import java.util.ArrayList;
import java.util.Collections;

public class SortLinkedList {

    public static Node partition(Node node, int x) {

        ArrayList<Integer> arrayListGreaterOrEqual = new ArrayList<>();
        ArrayList<Integer> arrayListLesser = new ArrayList<>();

        while(node != null) {
            if(node.data > x){
                arrayListGreaterOrEqual.add(node.data);
            } else if (node.data == x){
                arrayListGreaterOrEqual.add(0, node.data);
            } else {
                arrayListLesser.add(node.data);
            }
            node = node.next;
        }

        Node headNode = null, head = null;

        for(int data: arrayListLesser){
            Node newNode = new Node(data);
            if(headNode == null)
               head = headNode = newNode;
            else {
                head.next = newNode;
                head = newNode;
            }
        }
        for(int data: arrayListGreaterOrEqual){
            Node newNode = new Node(data);
            if(headNode == null)
                head = headNode = newNode;
            else {
                head.next = newNode;
                head = newNode;
            }
        }

        return headNode;
    }
}
