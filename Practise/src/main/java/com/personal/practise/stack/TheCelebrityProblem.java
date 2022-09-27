package com.personal.practise.stack;

import java.util.ArrayList;

public class TheCelebrityProblem {

    public int celebrity(int M[][], int n) {
        boolean isCelebrity = true;
        ArrayList<Integer> celebrityIndex = new ArrayList<>();

        for(int i = 0; i < n; i++){

            for (int j = 0; j < n; j++){
                if (M[i][j] == 1){
                    isCelebrity = false;
                }
            }

            if ( isCelebrity ) {
                celebrityIndex.add(i);
            }
            if (celebrityIndex.size() > 1) {
                break;
            }
            isCelebrity = true;
        }

        if ( celebrityIndex.size() == 1) {
            for (int k = 0; k < n; k++) {
                if (k != celebrityIndex.get(0) && M[k][celebrityIndex.get(0)] != 1) {
                    return -1;
                }
            }
        }

        return celebrityIndex.size() == 1 ? celebrityIndex.get(0) : -1;
    }
}
