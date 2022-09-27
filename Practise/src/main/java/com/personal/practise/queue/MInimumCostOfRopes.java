package com.personal.practise.queue;

import java.util.*;

public class MInimumCostOfRopes {

    public long minCost(long arr[], int n) {
        PriorityQueue queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
             queue.add(arr[i]);

        long cost = 0;
        while (queue.size()!=1){
            Long first  = (Long) queue.poll();
            Long second = (Long) queue.poll();
            cost = cost + first + second;
            queue.add(first+second);
        }
         return cost;
    }
}
