package com.personal.practise.linkedlist;

public class FlattenLinkedList {

        Node flatten(Node root) {
            Node l1 = root;
            Node l2 = root.next;
            while( l2!=null ){
                l1 = merge(l1,l2);
                l2 = l2.next;
            }
            return l1;
        }

        Node merge(Node l1, Node l2){
            Node currentHead = new Node(0);
            Node current = currentHead;
            while (l1 != null && l2 != null){
                if(l1.data >= l2.data){
                    currentHead.arb = l2;
                    currentHead = currentHead.arb;
                    l2 = l2.arb;
                } else {
                    currentHead.arb = l1;
                    currentHead = currentHead.arb;
                    l1 = l1.arb;
                }
            }
            if(l1!=null){
                currentHead.arb = l1;
            }

            if(l2!=null){
                currentHead.arb = l2;
            }
            return current.arb;
        }
}
