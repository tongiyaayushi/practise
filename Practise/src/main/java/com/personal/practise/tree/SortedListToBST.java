package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {

    public Node sortedListToBST(Node head)
    {
        List<Integer> list = convertToArrayList(head);
        return constructBST(list, 0, list.size()-1);
    }

    public Node constructBST(List<Integer> list, int startIndex, int endIndex){
        if(startIndex > endIndex)
            return null;

        if(startIndex == endIndex)
            return new Node(list.get(startIndex));

        int mid = (endIndex + startIndex + 1) / 2;
        Node node  = new Node(list.get(mid));

        node.left = constructBST(list, startIndex,mid-1 );
        node.right = constructBST(list, mid+1, endIndex);

        return node;
    }

    public List<Integer> convertToArrayList(Node head){
        List<Integer> list = new ArrayList<>();
       while (head != null){
           list.add(head.data);
           head = head.next;
       }
       return list;
    }

}
