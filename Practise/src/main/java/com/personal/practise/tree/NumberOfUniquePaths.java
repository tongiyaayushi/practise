package com.personal.practise.tree;

public class NumberOfUniquePaths {

    public int NumberOfPath(int a, int b) {
        if (a == 1 && b == 1)
            return 0;

        return uniquePaths(0,0,a,b);
    }

    public int uniquePaths(int i, int j, int a, int b){
        if (i == a-1 || j == b-1)
            return 1;

        return uniquePaths(i,j+1, a, b) + uniquePaths(i+1,j, a, b);
    }

    public int NumberOfPathIterative(int a, int b) {

        int[][] abMatrix = new int[a][b];
        for(int i = 0; i < b; i++){
            abMatrix[0][i] = 1;
        }

        for(int i = 0; i < a; i++){
            abMatrix[i][0] = 1;
        }

        for (int i = 1; i < a; i++){
            for (int j = 1; j < b; j++ ){
                abMatrix[i][j] = abMatrix[i][j-1] + abMatrix[i-1][j];
            }
        }

        return abMatrix[a-1][b-1];
    }
}
