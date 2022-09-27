package com.personal.practise.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MajorityElement {
    int majorityElement(int a[], int size)
    {
        if(size == 1)
            return a[0];

        int n = size/2;
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int i = 0 ; i <= n ; i++){
            Integer count = countMap.get(a[i]);
            if (null != count){
                countMap.replace(a[i],++count);
            } else {
                countMap.put(a[i],1);
            }

        }

        if(countMap.size() > n) return -1;

        for(int i = n+1 ; i < size ; i++){
            Integer count = countMap.get(a[i]);
            if (null != count) {
                if (count > n)
                    return a[i];
                countMap.replace(a[i],++count);
            }
            else
                countMap.put(a[i],1);
        }
        if( countMap.size() > (n+1) ) return -1;
        else {
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > n){
                    return entry.getKey();
                }
            }
        }

        Set<Map.Entry<Integer,Integer>> entries = countMap.entrySet();
        Iterator<Integer> itr = countMap.values().iterator();//keySet().iterator();
        while (itr.hasNext()){
            int key= itr.next();
        }
        return -1;
    }
}
