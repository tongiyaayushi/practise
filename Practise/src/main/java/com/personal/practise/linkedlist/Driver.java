package com.personal.practise.linkedlist;

import java.util.Scanner;

class Driverclass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1;i < n;i++)
            {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.arb = temp;
                temp.next = n1;
                temp = n1;
            }

            head = MergeSortDoublyLinkedList.sortDoubly(head);
            printList(head);
        }
    }
    public static void printList(Node node)
    {
        Node temp = node;
        while(node != null)
        {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.arb;
        }
        System.out.println();
    }
}

