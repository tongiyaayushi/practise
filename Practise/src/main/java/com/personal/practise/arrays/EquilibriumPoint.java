package com.personal.practise.arrays;

public class EquilibriumPoint {

    public static int equilibriumPoint(long arr[], int n) {

        if(n==1)
            return 1;

        int left[] =  new int[n];;
        int right[]=  new int[n];;
        left[0]= 0;
        right[n-1] = 0;

        for(int i=1;i<n;i++){
            left[i] = left[i-1] + (int)arr[i-1];
        }
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] + (int)arr[i+1];
        }

        for(int i=0; i<n;i++){
            if(left[i]==right[i]){
                return i+1;
            }
        }
        return -1;
        // Your code here
    }
}
