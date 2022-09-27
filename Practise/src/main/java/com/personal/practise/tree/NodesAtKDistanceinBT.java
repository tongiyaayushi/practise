package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.*;

public class NodesAtKDistanceinBT {
    static Node targetNode = null;
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        Map<Node, Node> parentMapping = new HashMap<>();
        getParentMapping(root, null, parentMapping);
        ArrayList<Integer> list = new ArrayList<>();
        getTargetNode(target,root);
        getAllNodesAtKDistance(targetNode,k,parentMapping, list);
        Collections.sort(list);
        return list;
    }

    static Queue<Node> iteratedItems = new LinkedList<>();

    public static void getAllNodesAtKDistance(Node targetNode, int k, Map<Node, Node> parentMapping, List<Integer> list){

        if (targetNode == null) {
            return ;
        }
        if (iteratedItems.contains(targetNode))
            return;

        iteratedItems.add(targetNode);
        if (0 == k)
            list.add(targetNode.data);

        getAllNodesAtKDistance(targetNode.left, k-1, parentMapping, list);
        getAllNodesAtKDistance(targetNode.right, k-1, parentMapping, list );
        getAllNodesAtKDistance(parentMapping.get(targetNode), k-1, parentMapping, list);

    }

    public static void getParentMapping(Node root, Node parent, Map<Node, Node> parentMapping){
        if (root == null)
            return;
        parentMapping.put(root,parent);
        getParentMapping(root.left, root, parentMapping);
        getParentMapping(root.right, root, parentMapping);
    }


    public static void getTargetNode(int target, Node root){
        if (root == null)
            return;

        if(root.data == target)
            targetNode = root;

        getTargetNode(target,root.left);
        getTargetNode(target,root.right);
    }
}
