package com.personal.practise.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BicycleParkingSlots {
    final public int solution(int[] A) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
               list.add(A[i]);
        }
        Collections.sort(list);
        int maxDist = 0;
        for (int i = 0; i < A.length-1; i++){
            maxDist = Math.max(maxDist,list.get(i+1)- list.get(i));
        }
        return maxDist >= 2 ? maxDist / 2 : 0;
    }
}
