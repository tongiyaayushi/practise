package com.personal.practise.linkedlist;

public class DeleteNodesWithGreaterValueOnRight {

    public Node compute(Node head) {
        Node dummy = new Node(0);

        Node curr = dummy;

        while( head != null ){
            Node nextNodes = head.next;
            boolean greaterExistOnRight = false;
            while (nextNodes!=null){

                if(nextNodes.data > head.data) {
                    greaterExistOnRight = true;
                    break;
                }
                nextNodes = nextNodes.next;
            }
            if(!greaterExistOnRight){
                curr.next = new Node(head.data);
                curr = curr.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
