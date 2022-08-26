package com.personal.practise.sorting;

public class MergeSort {

    public void merge(int[] arr, int l, int r){

        if(l < r){
            int mid = l+(r-l)/2;
            merge(arr,l,mid);
            merge(arr,mid+1,r);
            sort(arr,l,mid,r);
        }
    }

    public void sort(int[] arr, int l, int m, int r){
        int leftLength = l-m+1;
        int rightLength = r-m;
        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        for(int i=0; i < leftLength; i++){
            left[i] = arr[i];
        }

        for (int i=0; i < rightLength;i++ ){
            right[i] = arr[m+1+i];
        }

        int i = 0, j = 0, k = 0;
        while(i < leftLength || j < rightLength){
            if (left[i] > right[j]){
                arr[k] = right[j];
                j++;
            } else {
                arr[k] = left[i];
                i++;
            }
            k++;
        }

        while(i<leftLength){
            arr[k]=left[i];
            i++;
            k++;
        }
        while (j<rightLength){
            arr[k]=left[j];
            j++;
            k++;
        }
    }

}
