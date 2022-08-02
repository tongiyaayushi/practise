package com.personal.practise.arrays;

public class InversionCount {

    long inversionCount(long arr[], long N) {
        if(N==1)
            return 0;
        int inversions = 0;

        /* Approach 1
            for (int i=0; i < N-1 ; i++){
                for (int k = i+1 ; k<N ; k++){
                    if(arr[i]>arr[k]){
                        inversions ++;
                    }
                }
        }*/

        // Approach 2
        inversions = countInversion(arr,0,(int)N-1);
        return inversions;
    }

    int countInversion(long arr[], int l, int r){
        int inversion = 0;
        if( l < r ){
            int m = l + (r-l)/2;
            inversion += countInversion(arr,l,m);
            inversion += countInversion(arr,m+1,r);
            inversion += countInversionWithSortingAndMerge(arr,l,r,m);
        }
        return inversion;
    }

    int countInversionWithSortingAndMerge(long arr[], int l, int r, int m){
        int inversions =0;
        int n1 = m-l+1;
        int n2 = r-m;
        long[] left = new long[n1];
        long[] right = new long[n2];

        for (int i=0;i<n1;i++){
            left[i] = arr[i];
        }

        for (int i=0;i<n2;i++){
            right[i] = arr[m+i];
        }

        int i=0, j=0, k=l;

        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
                inversions += n1-i;
            }
            k++;
        }

        while( i < n1 ){
            arr[k]=left[i];
            i++;
            k++;
        }

        while ( j < n2){
            arr[k]=right[j];
            j++;
            k++;
        }
        return inversions;
    }
}
