package com.personal.practise.stack;

import java.util.Stack;

public class StockSpanProblem {

    public int[] calculateSpan(int price[], int n) {
        int[] span = new int[n];
        span[0] = 1;
        for(int i = 1; i < n; i++ ){
                    int count = 1;
                    int j = i-1;
                    while (j >= 0){
                        if(price[j] > price[i])
                            break;

                        count++;
                        j--;
                    }
                    span[i] = count;
           }

        return span;
    }
}
