package com.personal.practise.stack;

import com.personal.practise.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalInSpiralForm {

    public ArrayList<Integer> findSpiral(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        queue.add(root);
        list.add(root.data);
        int isEvenOrOddIteration = 0;

        while (!queue.isEmpty() || !stack.isEmpty()) {
            isEvenOrOddIteration ++;
            while (!queue.isEmpty()){
                stack.add(queue.poll());
            }

            while ( !stack.isEmpty()){
                Node node = stack.pop();
                if (isEvenOrOddIteration % 2 == 1) {
                    if (node.left != null) {
                        list.add(node.left.data);
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right.data);
                        queue.add(node.right);
                    }
                } else{
                    if (node.right != null) {
                        list.add(node.right.data);
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        list.add(node.left.data);
                        queue.add(node.left);
                    }
                }
            }

        }
        return list;
    }
}
