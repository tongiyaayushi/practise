package com.personal.practise.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeIntInWndowOfSizeK {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        int arrayLength = N == 1 ? 1 : N-K+1;
        long[] firstNegativeIntegers = new long[arrayLength];
        if (N==1) {
            if (A[0] >= 0)
             firstNegativeIntegers[0] = 0;
            else
                firstNegativeIntegers[0] = A[0];
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i= 0;i < K; i++){
            if(A[i] < 0)
                queue.add(i);
        }

        for(int i = K ; i <= N; i++){

            if (!queue.isEmpty())
                    firstNegativeIntegers[i-K] = A[queue.peek()];
            else
                    firstNegativeIntegers[i-K] = 0;

            if(i != N && A[i] < 0)
                queue.add(i);

            if(!queue.isEmpty() && i - K == queue.peek())
                queue.poll();
        }

        return firstNegativeIntegers;
    }
}
