package com.personal.practise.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

    public class Orange {
        int row;
        int column;
        int time;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getRow() {
            return row;
        }
        public int getColumn() {
            return column;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        Orange(int row, int column, int time){
            this.row = row;
            this.column = column;
            this.time = time;
        }
    }


    public int orangesRotting(int[][] grid)
    {
        int time = 1;
        List<Orange> rottenOrangeIndexes = new ArrayList<>();
        List<Orange> freshOrangeIndexes = new ArrayList<>();

        int columns = grid[0].length;
        // here we have got the indexes of all the Rotten and Fresh Oranges
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < columns; j++){
                if(grid[i][j] == 2)
                    rottenOrangeIndexes.add(new Orange(i,j, time));
                else if(grid[i][j] == 1)
                    freshOrangeIndexes.add(new Orange(i,j, time));
            }
        }
        // here we will find out the time
        while(!freshOrangeIndexes.isEmpty()) {

                if (freshOrangeIndexes.isEmpty())
                    break;

                Orange rottenOrange = rottenOrangeIndexes.get(0);

                    int rottenOrangeRow = rottenOrange.getRow();
                    int rottenOranegColumn = rottenOrange.getColumn();
                    rottenOrangeIndexes.remove(rottenOrange);
                    for (int j = 0; j < freshOrangeIndexes.size(); j++) {
                        Orange fresOrange = freshOrangeIndexes.get(j);
                        int freshOrangeRow = fresOrange.getRow();
                        int freshOrangeColumn = fresOrange.getColumn();
                        fresOrange.setTime(time);
                        if (rottenOrangeRow > 0 && freshOrangeRow == rottenOrangeRow - 1 && freshOrangeColumn == rottenOranegColumn) {
                            freshOrangeIndexes.remove(fresOrange);
                            rottenOrangeIndexes.add(fresOrange);
                        } else if (rottenOrangeRow < grid.length - 1 && rottenOrangeRow + 1 == freshOrangeRow && freshOrangeColumn == rottenOranegColumn) {
                            freshOrangeIndexes.remove(fresOrange);
                            rottenOrangeIndexes.add(fresOrange);
                        } else if (rottenOranegColumn < columns - 1 && rottenOranegColumn + 1 == freshOrangeColumn && rottenOrangeRow == freshOrangeRow) {
                            freshOrangeIndexes.remove(fresOrange);
                            rottenOrangeIndexes.add(fresOrange);
                        } else if (rottenOranegColumn > 0 && rottenOranegColumn - 1 == freshOrangeColumn && rottenOrangeRow == freshOrangeRow) {
                            freshOrangeIndexes.remove(fresOrange);
                            rottenOrangeIndexes.add(fresOrange);
                        }
                    }


            }

        return rottenOrangeIndexes.get(0).getTime();
    }
}
