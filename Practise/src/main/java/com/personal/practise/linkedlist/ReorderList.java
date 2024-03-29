package com.personal.practise.linkedlist;

public class ReorderList {

    Node reorderlist(Node head) {
        // 1. divide the linkedlist
        Node slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2) Split the linked list in two halves
        // node1, head of first half    1 -> 2 -> 3
        // node2, head of second half   4 -> 5
        Node node1 = head;
        Node node2 = slow.next;
        slow.next = null;

        // 3) Reverse the second half, i.e., 5 -> 4
        node2 = reverseList(node2);

        // 4) Merge alternate nodes
        head = new Node(0); // Assign dummy Node

        // curr is the pointer to this dummy Node, which
        // will be used to form the new list
        Node curr = head;
        while (node1 != null || node2 != null) {

            // First add the element from first list
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            // Then add the element from second list
            if (node2 != null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        // Assign the head of the new list to head pointer
        head = head.next;
        return head;
    }

    public Node reverseList(Node head){
        Node curr = head, next, prev =null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
