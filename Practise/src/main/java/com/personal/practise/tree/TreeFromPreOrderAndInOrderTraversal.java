package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPreOrderAndInOrderTraversal {

    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;
    public Node buildTree(int in[], int pre[], int n) {

        for( int i = 0; i < pre.length ; i++ ){
            map.put(pre[i],i);
        }
        return buildTree(in, pre, 0, n-1);
    }

    public Node buildTree(int in[], int pre[], int inStrt, int inEnd){
        if(inStrt > inEnd)
        {
            return null;
        }

    /* Pick current node from Preorder traversal using preIndex
        and increment preIndex */
        int curr = pre[preIndex++];
        Node tNode;
        tNode = new Node(curr);

        /* If this node has no children then return */
        if (inStrt == inEnd)
        {
            return tNode;
        }

        /* Else find the index of this node in Inorder traversal */
        int inIndex = map.get(curr);

    /* Using index in Inorder traversal, construct left and
        right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }

}
