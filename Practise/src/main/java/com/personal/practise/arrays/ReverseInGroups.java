package com.personal.practise.arrays;

import java.util.ArrayList;

public class ReverseInGroups {
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        int start, end;
        for(int i=0;i*k<n;i++){
            start = i*k;
            if(start+k>n){
                end=n-1;
            } else{
                end = start + k -1;
            }
            reverse(start,end,arr);

        }
    }

    void reverse(int start, int end, ArrayList<Integer> arr){
        int j= end;
        for(int i= start;i<j;i++){
            swap(i,j,arr);
            j--;
        }
    }

    void swap(int arrIndexToSwap, int arrIndexToSwapWith, ArrayList<Integer> arr){
        int temp = arr.get(arrIndexToSwap);
        int valueOfSwap = arr.get(arrIndexToSwapWith);
        arr.set(arrIndexToSwap,valueOfSwap);
        arr.set(arrIndexToSwapWith,temp);
    }

}
