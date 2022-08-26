package com.personal.practise.tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CheckBST {

    public boolean isBST(Node root) {
        if(root == null)
            return false;

        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

     public boolean checkBST(Node root, int minValue, int maxValue){
         if(root == null)
             return true;

         if(root.data < minValue || root.data > maxValue)
            return false;

         return checkBST(root.right,root.data,maxValue) && checkBST(root.left, minValue, root.data) ;
     }
}
