package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.ArrayList;

public class BoundaryTraversal {

    public ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> list = new ArrayList<>();

        if(node.left !=null)
            addLeftBoundaryNodes(node, list);
        else
            list.add(node.data);

        if (!(node.left== null && node.right==null))
            addLeafNodes(node, list);

        if (node.right != null)
            addRightBoundaryNodes(node.right,list);

        return list;
    }

    boolean isleftTraversalCompleted;

    private void addLeftBound(Node root,
                              ArrayList<Integer> ans)
    {
        // Go left left and no left then right but again
        // check from left
        root = root.left;
        while (root != null) {
            if (!isLeaf(root)) {
                ans.add(root.data);
            }

            if (root.left != null) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
    }
    private boolean isLeaf(Node node)
    {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
    Node addLeftBoundaryNodes(Node node, ArrayList<Integer> list){
        if (node == null)
            return null;

        if(node.left == null && node.right == null) {
            isleftTraversalCompleted = true;
            return null;
        }

        if(!isleftTraversalCompleted)
            list.add(node.data);

        if (addLeftBoundaryNodes(node.left,list) == null && addLeftBoundaryNodes(node.right,list) == null){
            return node;
        }
        return node;
    }

    Node addRightBoundaryNodes(Node node, ArrayList<Integer> list){
        boolean isRightTraversalCompleted = false;
        if (node == null)
            return null;

        if(node.left == null && node.right == null) {
            isRightTraversalCompleted = true;
            return node;
        }

        if (addRightBoundaryNodes(node.right,list) == null && addRightBoundaryNodes(node.left,list) == null){
            return node;
        }

        if(!isRightTraversalCompleted)
            list.add(node.data);

        return node;
    }

    void addLeafNodes(Node node, ArrayList<Integer> list){
        if (node == null)
            return ;

        if(node.left == null && node.right == null) {
            list.add(node.data);
            return ;
        }

        addLeafNodes(node.left, list);
        addLeafNodes(node.right, list);

    }
}
