package com.personal.practise.arrays;

import java.util.Arrays;

public class MaxCircularSubarraySum {
    //Function to find maximum circular subarray sum.
     int circularSubarraySum(int a[], int n) {
         int sum = kadane(a,n);
         if(sum < 0){
             
         }
        return reverseKadane(a,n);
    }


     public int kadane(int a[], int n){
         int i = 0, maxSum = Integer.MIN_VALUE , sum = 0;
        do {
            sum += a[i];
            i++;
            if(sum > maxSum)
                maxSum = sum;
        } while( i < n);
       return maxSum;
    }

    public int reverseKadane(int a[], int n){
         // reverse the array one by one element until laste element and call the kadane algorithm
        int i = 0, maxSum = Integer.MIN_VALUE, kadaneSum = 0;
        int[] movedArr;
        do {
            if(i==0)
                kadaneSum  = kadane(a,n);
            else {
                movedArr = moveCircularArrFromIndex(i,a,n);
                kadaneSum = kadane(movedArr,n);
            }
            i++;
            if(kadaneSum > maxSum)
                maxSum = kadaneSum;
        } while (i < n );
        return maxSum;
    }

    public int[] moveCircularArrFromIndex(int index,int a[], int n){
        int [] movedArray = new int[n];
        for(int i = 0; i < index; i++){
            movedArray[n-index+i] = a[i];
        }
        int j = 0;
        for(int i = index; i < n;i++){
            movedArray[j] = a[i];
            j++;
        }
        System.out.println(Arrays.asList(movedArray));
        return movedArray;
    }
}
