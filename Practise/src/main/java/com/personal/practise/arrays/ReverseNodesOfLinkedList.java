package com.personal.practise.arrays;

public class ReverseNodesOfLinkedList {
    Node head;
    class Node {
       private int data;
       private Node next;

       public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /* Function to print linked list */
    void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public Node reverse(int k, Node head){
        int i = 0;
        Node current = head;
        Node prev = null , next = null;
        while ( i <= k ){
            next = current.next;
            // current.next me prev assign karna h
            current.next = prev;
            // current ko prev banana h
            prev = current;
            // current.next ko current banana h
            current = next;
            i++;
        }
        if (current!=null)
            head.next = current;
        return prev;
    }

//    public Node reverseDloublyLinkedList(int k, Node head){
//        // step 1 created the sublist from k+1 to end
//        // take into picture this input 1->2->3->4->5->6->7->8->NULL, K = 5
//        Node nextNode = head;
//        for (int i=1;i<=k;i++){
//            nextNode = nextNode.next;
//        }
//        Node subListToAdjoinNode = nextNode.next;
//        Node reverseFromNode = nextNode.prev;
//        nextNode.prev = null;
//        reverseFromNode.next = null;
//
//        Node headNodeNow = reverseFromNode;
//        // step 2 take into picture this now
//        // 1->2->3->4->5
//        // After first loop 1->2->3->4<-5<-NULL
//        for (int i=1; i<=k;i++){
//            Node prev = reverseFromNode.prev;
//            reverseFromNode.prev = reverseFromNode.next;
//            reverseFromNode.next = prev;
//            reverseFromNode = prev;
//        }
//
//        // at the end of the loop we will get 1<-2<-3<-4<-5<-NULL
//        // step 3 now we will have to attach the above suublist to this list
//        // NULL->6->7->8->NULL
//        // 5->4->3->2->1->6->...
//        reverseFromNode.next = subListToAdjoinNode;
//        subListToAdjoinNode.prev = reverseFromNode.next;
//        return headNodeNow;
//    }
}
