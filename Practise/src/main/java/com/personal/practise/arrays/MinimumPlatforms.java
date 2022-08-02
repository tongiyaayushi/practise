package com.personal.practise.arrays;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinimumPlatforms {

    int findPlatform(int arr[], int dep[], int n) {
        int minPlatforms = 1;
        Map<Integer,Integer> arrDepMap = new LinkedHashMap<>();
        for (int i = 0; i<n;i++) {
            arrDepMap.put(arr[i],dep[i]);
        }

        for (Map.Entry<Integer,Integer> arrDepSet : arrDepMap.entrySet() ){
            int platforms = 1;
            for(int i = 1;i<n;i++){
                // if arrival is between arrival and departure of comparing train
                if(arr[i] < arrDepSet.getValue() && arr[i] > arrDepSet.getKey()){
                    platforms ++;
                } else if(arr[i] < arrDepSet.getKey() && dep[i] > arrDepSet.getValue()){
                    // if arrival is before comparing train and departure is after comparing train
                    platforms ++;
                } else if(dep[i] > arrDepSet.getKey() && dep[i] < arrDepSet.getValue()){
                    platforms ++;
                } else if(arr[i] == arrDepSet.getValue()){
                    platforms ++;
                }
            }
            if(platforms > minPlatforms){
                minPlatforms = platforms;
            }
        }
        return minPlatforms;

//        int minPlatforms = 1;
//        Map<Integer,Integer> arrDepMap = new LinkedHashMap<>();
//        for (int i = 0; i<n;i++){
//            arrDepMap.put(arr[i],dep[i]);
//        }
//
//        for (Map.Entry<Integer,Integer> arrDepSet : arrDepMap.entrySet() ){
//            int platforms = 1;
//            for(int i = 1;i<n;i++){
//                if(arr[i] < arrDepSet.getValue() && arr[i] > arrDepSet.getKey()){
//                    platforms ++;
//                }
//            }
//            if(platforms > minPlatforms){
//                minPlatforms = platforms;
//            }
//        }
//        return minPlatforms;
    }
}
