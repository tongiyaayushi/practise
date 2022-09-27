package com.personal.practise.stack;

import java.util.Stack;

public class MaxRectangle {
    public int maxArea(int M[][], int n, int m) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j=0, count = 0;
        while(i < n){
            if(M[i][j] == M[i+1][j] && M[i+1][j] == 1){
                count ++;
            }
            j++;
            if ( j == n ){
                count = 0;
                stack.push(count);
                j=0;
                i++;
            }
        }

        return 0;

    }
}
