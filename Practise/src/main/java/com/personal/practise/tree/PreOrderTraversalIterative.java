package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreOrderTraversalIterative {

    public Node buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public ArrayList<Integer> preOrder(Node root)
    {
        Stack<Node> rightNodeList = new Stack<>();
        ArrayList<Integer> preOrder = new ArrayList<>();

        while(root !=null ){
            preOrder.add(root.data);

            if(root.left == null && root.right == null){
                if(rightNodeList.isEmpty()){
                    break;
                }
                root = rightNodeList.pop();
                continue;
            } else if(root.left == null && root.right != null){
                root = root.right;
                continue;
            }

            if (root.right != null)
                rightNodeList.add(root.right);

            if (root.left != null)
                root = root.left;
        }
        return preOrder;
    }
}
