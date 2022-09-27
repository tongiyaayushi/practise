package com.personal.practise;


public class Node
{
   public int data;
   public Node next;
   public Node left;
   public Node right;
   public Node(int key)
   {
      data = key;
     next = left = right = null;
   }
}