package com.personal.practise.stack;

import java.util.ArrayList;
import java.util.Stack;

public class Greedy132Buidings {

    static boolean recreationalSpot(int[] arr , int n){
        int[] noOfLargerElementsOnRight = new int[n];
        int[] noOfLargerElementsOnLeft = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n-1; i >= 0; i++){
            if (!s.isEmpty()){
                while (!s.isEmpty() && s.peek() <= arr[i]){
                    s.pop();
                }
                noOfLargerElementsOnRight[i] = s.isEmpty() ? 0: noOfLargerElementsOnRight[s.peek()]+1;
            }
            s.push(i);
        }


        for (int i = 0; i < n; i++){
            if (!s.isEmpty()){
                while (!s.isEmpty() && s.peek() <= arr[i]){
                    s.pop();
                }
                noOfLargerElementsOnLeft[i] = s.isEmpty() ? 0: noOfLargerElementsOnLeft[s.peek()]+1;
            }
            s.push(i);
        }

        int[] h1CandidatesIndex = new int[n-2];
        int j = 0;
        for ( int i = 0; i < n-1; i++ ){
            if(noOfLargerElementsOnRight[i] >= 2){
                h1CandidatesIndex[j] = i;
                j++;
            }
        }
        j=0;
        int[] h3CandidatesIndex = new int[n-2];
        for ( int i = 2; i < n-1; i++ ){
            if (noOfLargerElementsOnLeft[i] >= 1 ) {
                h3CandidatesIndex[j] = i;
            }
        }
    return true;

    }
}
