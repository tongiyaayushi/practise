package com.personal.practise.arrays;

import java.util.List;

/**
 *  nearly similar rectangles solution
 *
 */
public class NearlySimilarRectanglesSolution {


    /**
     * find nearly similar rectangles
     * Two rectangle i and j where (i < j) are nearly  similar if the ratio of their length and breadth is equal
     * @param rectangleSides rectangleSides
     * @return {@link long}
     */
    public long findNearlySimilarRectangles(List<List<Long>> rectangleSides){
        int numberOfNearlySimilarRectangles = 0;
        // normal java solution
        for (int i=0 ; i < rectangleSides.size()-1; i++){

            List<Long> nearlySimilarRectangleTest = rectangleSides.get(i);

            for (int j=i+1 ; j < rectangleSides.size(); j++){

                List<Long> nearlySimilarRectangleTestCandidate = rectangleSides.get(j);

                double lengthRatio = (double)nearlySimilarRectangleTest.get(0) / nearlySimilarRectangleTestCandidate.get(0);
                double breadthRatio = (double)nearlySimilarRectangleTest.get(1) / nearlySimilarRectangleTestCandidate.get(1);

                if (lengthRatio == breadthRatio)
                    numberOfNearlySimilarRectangles ++;
            }
        }

        return numberOfNearlySimilarRectangles;
    }
}
