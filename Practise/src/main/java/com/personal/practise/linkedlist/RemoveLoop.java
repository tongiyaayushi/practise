package com.personal.practise.linkedlist;

public class RemoveLoop {

    public void removeLoop(Node head){
        Node slow = head;
        Node fast = head;
        Node arb = head;

        while (fast != null && fast.next != null) {
            arb = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if(slow == fast){
            fast = head;
            while(slow  != fast ){
                arb = slow;
                slow = slow.next;
                fast = fast.next;
            }

            arb.next = null;
        } else return;
    }
}
