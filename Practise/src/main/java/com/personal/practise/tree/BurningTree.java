package com.personal.practise.tree;

import com.personal.practise.Node;

import java.util.*;

public class BurningTree {
    static Node n1 = null;

    public int minTime(Node root, int target)
    {
        Map<Node,Node> map = new HashMap<>();
        getparent(root, null, map);
        getnode(root,target);
        List<Node> iteratedNodes = new ArrayList<>();
        return calculateDistanceFromEachLeafNode(n1, 0, map, iteratedNodes);
    }


    public static int calculateDistanceFromEachLeafNode(Node target, int dist,  Map<Node,Node> map, List<Node> iteratedNodes){
        if(target == null)
            return dist - 1;

        if(iteratedNodes.contains(target))
            return Integer.MIN_VALUE;

        iteratedNodes.add(target);
        int leftLeafDist = Integer.MIN_VALUE;
        int rightLeafDist = Integer.MIN_VALUE;
        int otherLeafDist = Integer.MIN_VALUE;
        leftLeafDist = calculateDistanceFromEachLeafNode(target.left, dist++, map, iteratedNodes);
        rightLeafDist = calculateDistanceFromEachLeafNode(target.right, dist++, map, iteratedNodes);
        otherLeafDist = calculateDistanceFromEachLeafNode(map.get(target),dist++, map, iteratedNodes);

        return Math.max(Math.max(leftLeafDist,rightLeafDist),otherLeafDist);
    }


    public static void getparent(Node root, Node parent,
                   Map<Node, Node> map) {
        if (root == null)
            return;

        map.put(root, parent);
        getparent(root.left, root, map);
        getparent(root.right, root, map);

        return;
    }

    public static void getnode(Node root, int a)
    {
        if (root == null)
            return;

        if (root.data == a)
            n1 = root;

        getnode(root.left, a);
        getnode(root.right, a);

        return;
    }
}
