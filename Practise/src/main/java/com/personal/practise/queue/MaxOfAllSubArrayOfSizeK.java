package com.personal.practise.queue;

import java.util.*;

public class MaxOfAllSubArrayOfSizeK {

    public ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> maxOfSubArr = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> consecutiveMax = new Stack<>();
        int max = -1;
        for (int i=0; i < k; i++){
            if(max > arr[i] ) {

            } else {
                max = arr[i];
            }
            queue.add(arr[i]);
        }
        maxOfSubArr.add(max);
        consecutiveMax.push(max);
        for (int i = 0; i < n-k ; i++){

            int element = queue.poll();

            if (element == arr[k+i]) {
                maxOfSubArr.add(max);
                continue;
            }
            if(element == max) {
                consecutiveMax.pop();
                int newMax = 0;
                for(int j = i+1; j < i+k+1; j++){
                    newMax = Math.max(newMax,arr[j]);
                }
                max = newMax;
            } else {
                max = Math.max(max,arr[k+1]);
            }
            consecutiveMax.push(max);
            queue.add(arr[k+i]);
            maxOfSubArr.add(max);
        }
        return maxOfSubArr;
    }

    public ArrayList<Integer> printMax(int arr[], int N, int K)
    {
        ArrayList<Integer> maxOfSubArr = new ArrayList<>();
        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < K; ++i) {

            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty()
                    && arr[i] >= arr[Qi.peekLast()])

                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < N; ++i) {

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            maxOfSubArr.add(arr[Qi.peek()]);

            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - K)
                Qi.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty())
                    && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        maxOfSubArr.add(arr[Qi.peek()]);
        return maxOfSubArr;
    }
}
