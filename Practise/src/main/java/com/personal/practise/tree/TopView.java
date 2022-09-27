package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopView {
    int maxLeftTraversalHeight = 0, maxRightTraversalHeight = 0;
    Stack<Integer> queue = new Stack<>();
    Queue<Integer> stack = new LinkedList<>();

    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        topViewLeftTraversal(root, 0,0);
        while (queue.size() > 1){
            int a = queue.pop();
            list.add(a);
            System.out.println("First "+ a);
        }
        topViewRightTraversal(root,0,0);
        while (!stack.isEmpty()){
            int b = stack.poll();
            list.add(b);
            System.out.println("Second "+ b);
        }
        return list;
    }

    public void topViewLeftTraversal(Node root , int leftTraversalHeight, int rightTraversalHeight){
        if( root == null )
            return ;

        if ((leftTraversalHeight >= maxLeftTraversalHeight + 2 && rightTraversalHeight > 0) || (rightTraversalHeight == 0))
            queue.add(root.data);

        topViewLeftTraversal(root.left,  leftTraversalHeight+1, rightTraversalHeight);

        maxLeftTraversalHeight = Math.max(maxLeftTraversalHeight,leftTraversalHeight);

        topViewLeftTraversal(root.right, leftTraversalHeight, rightTraversalHeight+1);
    }

    public void topViewRightTraversal(Node root , int rightTraversalHeight, int leftTraversalHeight){
        if( root == null )
            return;
        topViewRightTraversal(root.right,  rightTraversalHeight+1, leftTraversalHeight);

        if ((rightTraversalHeight >= maxRightTraversalHeight + 2 && leftTraversalHeight > 0) || (leftTraversalHeight == 0))
            stack.add(root.data);

        maxRightTraversalHeight = Math.max(maxRightTraversalHeight,rightTraversalHeight);

        topViewRightTraversal(root.left, rightTraversalHeight, leftTraversalHeight+1);
    }
    static class pair {
        Node node;
        int hd;

        pair() {}
        pair(Node node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }

    static ArrayList<Integer> topView1(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));
        int hd = 0, l = 0, r = 0;

        Stack<Integer> left = new Stack<>();

        // ArrayList is for holding right node's data
        ArrayList<Integer> right = new ArrayList<>();
        Node node = null;

        while (!q.isEmpty()) {
            node = q.peek().node;
            hd = q.peek().hd;

            if (hd < l) {
                left.push(node.data);
                l = hd;
            }

            if (hd > r) {
                right.add(node.data);
                r = hd;
            }

            if (node.left != null) {
                q.add(new pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new pair(node.right, hd + 1));
            }

            q.poll();
        }

        while (!left.isEmpty()) {
            list.add(left.pop());
        }
        list.add(root.data);
        for (int d : right) {
            list.add(d);
        }
        return list;
    }
}
