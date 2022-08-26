package com.personal.practise.tree;


public class Node
{
   int data;

   public Node left;
   public Node right;
   public Node(int key)
   {
      data = key;
     left = right = null;
   }
}