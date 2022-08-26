package com.personal.practise.tree;

public class CountLeaves {

    int countLeaves(Node node)
    {
        int count = 0,countLeft = 0, countRight = 0;
        if(node.left == null && node.right == null){
            return  1;
        }

        if(node.left !=null)
          countLeft = countLeaves(node.left);

        count +=countLeft;

        if(node.right !=null ) {
            countRight = countLeaves(node.right);
        }
        count += countRight;
        return count;
    }
}
