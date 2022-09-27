package com.personal.practise.queue;

import java.util.*;

public class LRUCache {

    private static Map<Integer, Integer> cache = new HashMap<>();
    private static Queue<Integer> queue = new LinkedList<>();
    private static int cap = 2;

    public LRUCache(int cap)
    {
        this.cap = cap;

    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
       if (queue.contains(key)) {
           queue.remove(key);
           queue.add(key);
           return cache.get(key);
       }


      return -1;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if( cache.size() < cap ){
            if (queue.contains(key))
                queue.remove(key);

        } else if (!queue.isEmpty()){

            if(queue.contains(key)) {
                queue.remove(key);
            } else {
                int lruKey = queue.poll();
                cache.remove(lruKey);
            }

        }
        cache.put(key,value);
        queue.add(key);
    }
}
