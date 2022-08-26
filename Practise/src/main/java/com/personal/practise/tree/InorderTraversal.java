package com.personal.practise.tree;

import java.util.ArrayList;
import java.util.List;

import com.personal.practise.tree.Node;

public class InorderTraversal {

    public ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null) {
            return list;
        }

        ArrayList<Integer> ans1= inOrder(root.left);
        list.addAll(ans1);
        list.add(root.data);

        ArrayList<Integer> ans2 = inOrder(root.right);
        list.addAll(ans2);

        return list;
    }

}
