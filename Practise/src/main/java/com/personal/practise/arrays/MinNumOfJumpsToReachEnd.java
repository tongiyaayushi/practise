package com.personal.practise.arrays;

public class MinNumOfJumpsToReachEnd {
    //Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}

    public int minNumOfJumps(int[] arr){
        int numOfJumps=0;
        int biggestJumpNumber = arr[0];
        int biggestJumpNumberIndex = 0;
        int moves= biggestJumpNumber;
        do {
            for (int j =  biggestJumpNumberIndex + 1 ; j <= moves ; j++ ){
                if (arr[j] > biggestJumpNumber) {
                    biggestJumpNumber = arr[j];
                    biggestJumpNumberIndex = j;
                } else {
                    biggestJumpNumberIndex ++;
                }
            }
            moves = biggestJumpNumberIndex + biggestJumpNumber;
            numOfJumps ++;
        } while( arr.length > moves  );
        return numOfJumps + 1;
    }

}
