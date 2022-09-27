package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.*;

public class LowestCommonAncestor {

    public Node lca(Node root, int n1, int n2)
    {
        // first appraoch
        return lcaFind(root, n1, n2);

        //second approach
//        ArrayList<Integer> pathLeft = new ArrayList<>();
//        ArrayList<Integer> pathRight = new ArrayList<>();
//
//        if(findPath(root, n1, pathLeft) && findPath(root, n1, pathRight)){
//            int i;
//            for(i = 0; i < pathLeft.size() && i < pathRight.size(); i++){
//                if(pathLeft.get(i)!=pathRight.get(i))
//                    break;
//            }
//            return new Node(pathLeft.get(i-1));
//        }
    }

    boolean findPath(Node root, int n, ArrayList<Integer> path){
        if(root == null)
            return false;

        path.add(root.data);
        if(root.data == n)
            return true;

        if(root.left!=null && findPath(root.left,n,path))
            return true;

        if(root.right!=null && findPath(root.right,n,path))
            return true;

        path.remove(root.data);
        return false;
    }

    public Node lcaFind(Node root , int n1, int n2){
        if(root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        Node leftLca = lcaFind(root.left, n1, n2);
        Node rightLca = lcaFind(root.right, n1, n2);

        if(leftLca!=null && rightLca!=null)
            return root;

        return leftLca!=null ? leftLca : rightLca;
    }
}
