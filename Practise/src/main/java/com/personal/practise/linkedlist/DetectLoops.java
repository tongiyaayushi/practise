package com.personal.practise.linkedlist;

import java.util.ArrayList;

public class DetectLoops {

    public static boolean detectLoop(Node head){
        ArrayList<Node> nodeArrayList = new ArrayList<>();
            while (head!=null){
                if(nodeArrayList.contains(head)){
                    return true;
                }
                nodeArrayList.add(head);
                head = head.next;

            }
        return false;
    }
}
