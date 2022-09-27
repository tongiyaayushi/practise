package com.personal.practise.tree;

import com.personal.practise.Node;

public class SumOfBT {

    static int sumBT(Node head){
        int sumOfNodes = 0;
        if (head == null)
            return 0;

        sumOfNodes = head.data;
        int leftSubTreeSum = sumBT(head.left);
        sumOfNodes += leftSubTreeSum;
        int rightSubtreeSum = sumBT(head.right);
        sumOfNodes += rightSubtreeSum;
        return sumOfNodes;
    }
}
