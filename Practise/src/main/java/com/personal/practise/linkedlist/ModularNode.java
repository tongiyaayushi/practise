package com.personal.practise.linkedlist;

public class ModularNode {

    public static int moduarNode(Node head, int k)
    {
        int lastModularValue = -1;
        int index=1;

        while( head!=null ){

            if((index % k) ==0){
              lastModularValue = head.data;
            }

            head = head.next;

            index++;
      }
        return lastModularValue;
    }
}
