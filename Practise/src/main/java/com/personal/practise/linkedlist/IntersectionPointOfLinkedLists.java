package com.personal.practise.linkedlist;

public class IntersectionPointOfLinkedLists {

    int intersectPoint(Node head1, Node head2){
        int size1=0, size2=0;
        Node head1StartNode = head1, head2StartNode = head2;

        while(head1 != null){
            size1++;
            head1 = head1.next;
        }

        while (head2 != null){
            size2++;
            head2 = head2.next;
        }

        if(size1 > size2){
            int sizeDiff = size1 - size2;
            for (int i =0 ; i< sizeDiff;i++){
                head1StartNode = head1StartNode.next;
            }
        }

        if(size2 > size1){
            int sizeDiff = size2 - size1;
            for (int i =0 ; i< sizeDiff;i++){
                head2StartNode = head2StartNode.next;
            }
        }

        while ( head1StartNode != null || head2StartNode != null ){

            if( head1StartNode == head2StartNode ){
                return head1StartNode.data;
            }

            head1StartNode = head1StartNode.next;

            head2StartNode = head2StartNode.next;

        }

        return -1;
    }
}
