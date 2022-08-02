package com.personal.practise.arrays;

public class CountSubArray {

    // my method
    long countSubarray(int N,int A[],long L,long R) {
        int count=0, sum = A[0];
        if(Long.parseLong(String.valueOf(sum)) >= L && Long.parseLong(String.valueOf(sum)) <= R){
            count++;
        }
        for (int i=0, j=i+1 ; i<N-1 & j< N;){
            sum = sum + A[j];
            if( Long.parseLong(String.valueOf(sum)) >= L && Long.parseLong(String.valueOf(sum)) <= R ){
                count ++;
                if(j==N-1){
                    i++;
                    j=i+1;
                    sum = A[i];
                    if(Long.parseLong(String.valueOf(A[i])) >= L && Long.parseLong(String.valueOf(A[i])) <= R){
                        count++;
                    }
                } else {
                    j++;
                }
            } else if (Long.parseLong(String.valueOf(sum)) <= L || Long.parseLong(String.valueOf(sum)) <= R){
                if(j==N-1){
                    i++;
                    j=i+1;
                    sum = A[i];
                    if(Long.parseLong(String.valueOf(A[i])) >= L && Long.parseLong(String.valueOf(A[i])) <= R){
                        count++;
                    }
                } else {
                    j++;
                }
            } else {
                i++;
                j=i+1;
                sum = A[i];
                if(Long.parseLong(String.valueOf(A[i])) >= L && Long.parseLong(String.valueOf(A[i])) <= R){
                    count++;
                }
            }
        }
        return count;
    }


    // second way of doing this
    long countSubarray1(int N,int A[],long L,long R) {
        int Rcnt = countSub(A, N, R);
        int Lcnt = countSub(A, N, L - 1);
        return Rcnt - Lcnt;
    }

    static int countSub(int arr[], int n, long x) {
        int st = 0, end = 0, sum = 0, cnt = 0;
        while (end < n) {
            sum += arr[end];
            while (st <= end && sum > x) {
                sum -= arr[st];
                st++;
            }
            cnt += (end - st + 1);
            end++;
        }
        return cnt;
    }

}
