package com.personal.practise.tree;

import com.personal.practise.Node;

public class CountAllNodes {

    public static int getSize(Node root)
    {
        int nodeCount = 0;

        if(root == null)
            return nodeCount;

        nodeCount ++;
        int leftNodesCount = getSize(root.left);
        nodeCount ++;
        int rightNodesCount = getSize(root.right);
        return leftNodesCount + rightNodesCount + 1;
    }
}
