package com.personal.practise.linkedlist;

import java.util.Scanner;

public class LinkedList {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0) {
            int n=sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            CountNodes ob = new CountNodes();
            System.out.println(ob.getCount(head));
        }
    }

}
