package com.personal.practise.linkedlist;


public class Node
{
   int data;
   public Node next;
   public Node arb;
   public Node left;
   public Node right;
   public Node(int key)
   {
      data = key;
      next = arb = left = right = null;
   }
}