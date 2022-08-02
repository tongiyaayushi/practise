package com.personal.practise.arrays;

import java.util.*;

public class FindDuplicatesInArray {

    public ArrayList<Integer> duplicates(int arr[], int n) {
        int maxSubarraySum=0;
        int[] sumOfAllPermCombination = new int[n*n];
        int k = 0;
        for(int i=0 ; i<n-1 ; i++){
            int sum = arr[i];
            for (int j = i+1 ; j<n ; j++){
                sumOfAllPermCombination[k] = sum;
                k++;
                sum += arr[j];
            }
        }
        for (int i = 0; i< sumOfAllPermCombination.length; i++){
            if(sumOfAllPermCombination[i] > maxSubarraySum){
                maxSubarraySum = sumOfAllPermCombination[i];
            }
        }


        Map<Integer,Integer> countMap = new HashMap<>();
        ArrayList<Integer> duplicatesList = new ArrayList<>();
        for (int i =0 ; i<n; i++){
            Integer count = countMap.get(arr[i]);
            if(count != null){
                countMap.replace(arr[i],++count);
            } else {
                countMap.put(arr[i],1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if (entry.getValue() >1){
                duplicatesList.add(entry.getKey());
            }
    }
        if (duplicatesList.isEmpty())
            duplicatesList.add(-1);
        else
            Collections.sort(duplicatesList);
        return duplicatesList;
    }
}
