package com.personal.practise.tree;

public class MinElementInTree {

    int minValue(Node node) {
       if(node == null)
           return -1;
       return findMin(node);
    }

    public int findMin(Node node){
        int minValue = Integer.MAX_VALUE;
        if(node == null)
            return minValue;

        int a = findMin(node.left);
        int b = findMin(node.right);
        return Math.min(node.data,Math.min(a,b));
    }
}
