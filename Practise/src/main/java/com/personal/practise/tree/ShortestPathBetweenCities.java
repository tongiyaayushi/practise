package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathBetweenCities {

    Boolean isX = false, isY = false;
    Stack<Integer> path = new Stack<>();

    public int shortestPath( int x, int y){
       int pathLength = 0;

       while (x!=y){

           if (x > y)
               x /= 2;
           else
               y /= 2;

           pathLength ++;
        }

       return pathLength;
    }

     public void pathFromXToY(int x, int y, Node root){
        if (root == null) {
            if (!path.isEmpty())
                path.pop();
            return;
        }
        if (root.data == x)
            isX = true;

        if (root.data == y)
            isY = true;

        if (isY && isX)
            return ;

        if (isX || isY)
            path.push(root.data);

        pathFromXToY(x, y, root.left);
        pathFromXToY(x, y, root.right);
    }

    public Node buildTree(Node root, int value, int destination){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while( value <= destination ){
            Node node = queue.poll();
            node.left = new Node(++value);
            queue.add(node.left);
            node.right = new Node(++value);
            queue.add(node.right);
        }
        return root;
    }

}
