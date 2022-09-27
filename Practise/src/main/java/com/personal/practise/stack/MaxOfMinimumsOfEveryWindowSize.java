package com.personal.practise.stack;

import java.util.*;

public class MaxOfMinimumsOfEveryWindowSize {

    public int[] maxOfMin(int[] arr, int n) {
        int[] MaxOfMinElementList = new int[n];
            List<Integer> MinimumElementsList = new ArrayList<>();
            int noOfElementsInCurrentWindow = 0;
            while (noOfElementsInCurrentWindow <= n-1){

                if (noOfElementsInCurrentWindow == 0){
                   for(int l = 0; l < n; l++){
                       MinimumElementsList.add(arr[l]);
                   }
                } else {

                for(int k = 0; k < n - noOfElementsInCurrentWindow; k++) {
                    int minInCurrentWindow = Integer.MAX_VALUE, count = 0, windowCounter = k;

                    while (count < noOfElementsInCurrentWindow) {
                        minInCurrentWindow = Math.min(minInCurrentWindow, Math.min(arr[windowCounter + 1], arr[windowCounter]));
                        count++;
                        windowCounter ++;
                    }
                    MinimumElementsList.add(minInCurrentWindow);
                }
                }

                Collections.sort(MinimumElementsList, Comparator.reverseOrder());
                MaxOfMinElementList[noOfElementsInCurrentWindow] = MinimumElementsList.get(0);
                MinimumElementsList.clear();
                noOfElementsInCurrentWindow++;
            }

        return MaxOfMinElementList;
    }


    public int[] maxOfMinOptimize(int[] arr, int n) {
        int[] MaxOfMinElementList = new int[n];
       for (int i = 0; i < n; i++) {
            MaxOfMinElementList[0] = Math.max(MaxOfMinElementList[0], arr[i]);
        }

        for (int j = 1; j < n; j++) {
            int maxInSlidindWindow = 0;
            for (int i = 0; i < n-j; i++) {
                int minElement = Math.min(arr[i+1], arr[i]);
                maxInSlidindWindow = Math.max(maxInSlidindWindow,minElement);
                arr[i] = minElement;
            }
            MaxOfMinElementList[j] = maxInSlidindWindow;
        }
        return MaxOfMinElementList;
    }

    public int[] maxOfMinOptimizea(int[] arr, int n) {
        int[] MaxOfMinElementList = new int[n];
        List<Integer> list = new LinkedList<>();
        MaxOfMinElementList[n-1] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            MaxOfMinElementList[0] = Math.max(MaxOfMinElementList[0], arr[i]);
            MaxOfMinElementList[n-1] = Math.min(MaxOfMinElementList[n-1], arr[i]);
        }

        for (int j = 0; j < n-2; j++)
            list.add(Math.min(arr[j+1], arr[j]));

        Collections.sort(list, Collections.reverseOrder());

        for(int i = 1; i < n-2; i++)
            MaxOfMinElementList[i] = list.get(i-1);

        return MaxOfMinElementList;
    }
}
