package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.ArrayList;

public class PreorderTraversal {
    static ArrayList<Integer> preorder(Node root)
    {
       ArrayList<Integer> list = new ArrayList<>();
       if(root == null)
           return list;

        list.add(root.data);
        ArrayList list1 = preorder(root.left);
        list1.addAll(list);

        ArrayList list2 = preorder(root.right);
        list2.addAll(list);
        return list;
    }
}
