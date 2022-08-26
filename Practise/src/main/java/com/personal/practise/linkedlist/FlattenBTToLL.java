package com.personal.practise.linkedlist;

public class FlattenBTToLL {
    public static void flatten(Node root)
    {
        Node curr = root, prev;
        while(curr.left != null){
            curr.right = curr.left;
            curr = curr.left;
        }
    }

    public void traverse(Node root){
        Node resultTree = root, prev = root;
        if(root != null){
            System.out.println(root.data);
            // traverse left first
            resultTree.right = root.left;
            resultTree = resultTree.right;

            if (root.left != null) {
                prev = root;
                root = root.left;
                traverse(root);
            }

            // traverse right after left
            root = prev;
            resultTree.right = root.right;
            resultTree = resultTree.right;
            if (root.right != null) {
                root = root.right;
                traverse(root);
            }

        }
    }
}
