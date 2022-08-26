package com.personal.practise.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergeSortDoublyLinkedList {

    static Node sortDoubly(Node head) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        //Node startNode = head;
        while (head!=null){
            arrayList.add(head.data);
            head = head.next;
        };

        int[] arr = new int[arrayList.size()];
        for (int i=0; i < arrayList.size(); i++){
            arr[i] = arrayList.get(i);
        }

        merge(arr,0,arrayList.size()-1);
        Node resultHead =null , newHead = null;
        for (int i = 0; i < arr.length; i++){
            Node newNode = new Node(arr[i]);
            if (i==0){
                newHead = resultHead = newNode;
            } else {
                newHead.next = newNode;
                newHead = newNode;
            }
        }
        return resultHead;
    }

    static void merge(int[] arr, int l, int r){

        if(l < r){
            int m = l+(r-l)/2;
            merge(arr,l,m);
            merge(arr,m+1,r);
            sort(arr,l,m,r);
        }
    }

   static void sort(int[] arr, int l,  int m, int r){
        int leftLength = m+1-l;
        int rightLength = r-m;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        for(int i=0; i < leftLength; i++){
            left[i] = arr[l+i];
        }

        for (int i=0; i < rightLength;i++ ){
            right[i] = arr[m+1+i];
        }

        int i = 0, j = 0, k = l;
        while(i < leftLength && j < rightLength){
            if (left[i] > right[j]){
                arr[k] = right[j];
                j++;
            } else {
                arr[k] = left[j];
                i++;
            }
            k++;
        }

        while(i<leftLength){
            arr[k]=left[i];
            i++;
            k++;
        }
        while (j < rightLength){
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}

