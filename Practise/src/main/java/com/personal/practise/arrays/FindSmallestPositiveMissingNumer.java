package com.personal.practise.arrays;

public class FindSmallestPositiveMissingNumer {
    public int missingNumber(int arr[], int size)
    {
        int negNumCount = shiftAllNegativeNumbers(arr,size);
        return findMissing(arr,size, negNumCount);
    }

    public int shiftAllNegativeNumbers(int arr[], int size){
        int j = 0;
        for (int i = 0 ; i < size; i++){
            if(arr[i] <= 0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        return j;
    }

    public int findMissing(int[] arr, int size, int countOfNegative){
        int[] missingEle = new int[size+1];
        int missingNum = size+1;
        for (int i = countOfNegative; i < size; i++){
            if (arr[i] <= size)
                missingEle[arr[i]] = -1;
        }

        for (int i=1; i<=size; i++){
            if(missingEle[i] >= 0 ){
                missingNum = i;
                break;
            }
        }
        return missingNum;
    }
}
