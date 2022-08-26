package com.personal.practise.arrays;

public class LargestRectangleOf1s {

    int maxArea(boolean[][] mat, int r, int c) {
         int[][] auxilaryMatrix = new int[r][c];

         // inject the auxilary array with count of consecutive 1's
         for (int i = 0; i < c; i++){
             for (int j = 0; j < r; j++ ){
                 if(Boolean.valueOf(mat[j][1]).equals(Boolean.TRUE)){
                     if(i != 0){
                         auxilaryMatrix[j][i] = auxilaryMatrix[j-1][i] +1;
                     }
                 }else {
                     auxilaryMatrix[j][i] = 0;
                 }
             }
         }

         // sort the auxilary array rows in decreasing order.
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++ ){

            }
        }
        return 0;
    }

}
