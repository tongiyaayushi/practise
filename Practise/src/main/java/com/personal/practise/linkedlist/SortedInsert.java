package com.personal.practise.linkedlist;

public class SortedInsert {

    public  Node sortedInsert(Node head,int data)
    {

        Node headNode = head;

        do {

            if(data - head.data > 0){
                head = head.next;

            } else {

                Node insertNode = new Node(data);
                insertNode.next = head.next;
                head.next = insertNode;

                // swap data
                int temp = head.data;
                head.data = insertNode.data;
                insertNode.data = temp;

                break;

            }

        } while(head.next != headNode);

        return headNode;
    }
}
