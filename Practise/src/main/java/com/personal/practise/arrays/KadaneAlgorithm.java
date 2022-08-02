package com.personal.practise.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KadaneAlgorithm {

    long maxSubarraySum(int arr[], int n){
        int maxSubarraySum = Integer.MIN_VALUE;
        int[] sumOfAllPermCombination = new int[n*n];
        int k = 0;
        for(int i=0 ; i<n ; i++){
            int sum = arr[i];
            sumOfAllPermCombination[k] = sum;
            k++;
            for (int j = i+1 ; j<n ; j++){
                sum += arr[j];
                sumOfAllPermCombination[k] = sum;
                k++;
            }
        }
        for (int i = 0; i< k; i++){
            if(sumOfAllPermCombination[i] > maxSubarraySum){
                maxSubarraySum = sumOfAllPermCombination[i];
            }
        }
        return maxSubarraySum;
    }

    long maxSubarraySumSecondApproach(int arr[], int n){
        int maxSum = arr[0], maxSoFar=arr[0] < 0 ? 0 : arr[0];
        for (int i=1;i<n;i++){
            if( maxSum > (maxSoFar + arr[i])){
                maxSum = maxSoFar + arr[i];
            }
            maxSoFar += arr[i];
            if (maxSoFar < 0)
                maxSoFar = 0;

        }
        return maxSum;
    }

    //A[] = {3,1,3,3,2}

}
