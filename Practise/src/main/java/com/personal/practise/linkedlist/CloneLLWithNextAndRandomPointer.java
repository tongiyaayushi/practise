package com.personal.practise.linkedlist;

import java.util.HashMap;

public class CloneLLWithNextAndRandomPointer {
    public static Node addToTheLast(Node head, Node node) {
        if (head == null) {
            head = node;
            return head;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
            return head;
        }
    }

    public static boolean validation(Node head, Node res) {

        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        /*if lengths not equal */

        if (len1 != len2) return false;

        HashMap<Node,Node> a = new HashMap<Node, Node>();

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {

            if(temp1==temp2)
                return false;

            if (temp1.data != temp2.data) return false;



            if (temp1.arb != null && temp2.arb != null) {
                if (temp1.arb.data != temp2.arb.data) return false;
            } else if (temp1.arb != null && temp2.arb == null)
                return false;
            else if(temp1.arb== null && temp2.arb !=null)
                return false;
            if(!a.containsKey(temp1)){
                a.put(temp1,temp2);
            }

            temp1 = temp1.next;
            temp2 = temp2.next;

        }

        if(a.size()!=len1)
            return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {

            if (temp1.arb != null && temp2.arb != null) {
                if (a.get(temp1.arb) != temp2.arb) return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    public Node copyList(Node head) {
        Node newHead = null , newCurr = null;
        Node headForPointerLoop = head, headCopy = head;
        boolean dataFound = false;
        while ( head != null ){

           if( newHead == null ){
               newHead = newCurr = new Node(head.data);
           } else {
               newCurr.next = new Node(head.data);
               newCurr = newCurr.next;
           }
           head = head.next;
        }
        newCurr = newHead;
        while ( headCopy != null ){
            if( headCopy.arb != null ){
                int value = headCopy.arb.data;
                Node headCopyCopy = newCurr;
                while (headCopyCopy != null){
                    if(headCopyCopy.data == value) {
                        dataFound = true;
                        break;
                    }
                }
                if(dataFound) {
                    newCurr.arb = headCopyCopy;
                    newCurr = newCurr.next;
                }
            }
            headCopy = headCopy.next;
        }

       return newHead;
    }

    Node copyListConstantSpace(Node head) {
        Node preservedHead = head;
       Node original = head;
        while(head!=null){
            Node newNode = new Node(head.data);
            Node temp = head.next;
            head.next = newNode;
            newNode.next = temp;
            head = head.next.next;
        }

        while(preservedHead != null){
            if(preservedHead.arb != null){
                preservedHead.next.arb = preservedHead.arb.next;
            }
            preservedHead = preservedHead.next.next;
        }
        Node copy = original.next, copyPointer = copy;
        while(original != null){
                original.next = original.next.next;
                original = original.next;
                if(copyPointer.next != null) {
                    copyPointer.next = copyPointer.next.next;
                }
                copyPointer = copyPointer.next;

        }

        return copy;
    }
}
