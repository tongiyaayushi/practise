package com.personal.practise.arrays;

public class MinElementInASortedRotatedArray {

    int findMin(int arr[], int n)
    {
        int min = arr[0];
        for (int i = 0; i < n; i++){
            if(i < n-1) {
                if (arr[i + 1] < arr[i]) {
                    min = arr[i + 1];
                    break;
                }
            }
        }
        return min;
    }
}
