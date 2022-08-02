package com.personal.practise.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class SubArrayWithGivenSum {


        //Function to find a continuous sub-array which adds up to a given number.
        static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
        {
            ArrayList<Integer> indexPositions = new ArrayList<>();

            for (int i=0; i <= n-1; i++){

                int sum = arr[i];

                if(sum == s){
                    indexPositions.add(i+1);
                    indexPositions.add(i+1);
                    return indexPositions;
                }

                for (int j = i+1; j <= n-1; j++){

                    sum = sum + arr[j];

                    if(sum > s){
                        break;
                    } else if (sum == s){
                        indexPositions.add(i+1);
                        indexPositions.add(j+1);
                        return indexPositions;
                    }
                }
            }
            indexPositions.add(-1);
            return indexPositions;
        }

}
