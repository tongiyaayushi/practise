package com.personal.practise.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RotateLinkedListInGroup {
    public static Node reverse(Node node, int k)
    {

        Node head = null, tail=null;
        int counter = 0, index = 0;
        ArrayList<Integer> nodeData = new ArrayList<>();
        ArrayList<Integer> finalNodeData = new ArrayList<>();
        while(node !=null){

            nodeData.add(node.data);
            counter++;

            if (counter == k || node.next == null){
                Collections.reverse(nodeData);
                finalNodeData.addAll(index,nodeData);
                nodeData = new ArrayList<>();
                counter = 0;
                index +=k;
            }

            node = node.next;

        }
        for (int reversedNodesData : finalNodeData){
            if(head == null){
                tail = head = new Node(reversedNodesData);
            } else {
                tail.next = new Node(reversedNodesData);
                tail = tail.next;
            }
        }
        return head;

    }
}
