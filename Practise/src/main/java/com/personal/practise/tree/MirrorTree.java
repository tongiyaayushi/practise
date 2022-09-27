package com.personal.practise.tree;

import com.personal.practise.Node;

public class MirrorTree {

    public void mirror(Node node) {
        if(node == null)
            return;

        mirror(node.left);
        mirror(node.right);

        // swap the nodes not just the data
        if( node.left != null || node.right != null ) {
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

}
