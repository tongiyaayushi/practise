package com.personal.practise.arrays;

import java.util.Collections;
import java.util.List;

public class MinimumTimeToProcessFilesGivenNCoresAndLimitOfParalellExecution {

    public int findMinimumTime(int numOfCores, int limit, List<Integer> files) {
        int timeToReadAllFiles = 0;
        Collections.sort(files);
        for (int i = files.size() - 1; i >= 0; i--) {
            if ((files.get(i) % numOfCores == 0) && limit > 0) {
                timeToReadAllFiles = timeToReadAllFiles + files.get(i) / numOfCores;
                limit--;
            } else {
                timeToReadAllFiles = timeToReadAllFiles + files.get(i);
            }
        }
        return timeToReadAllFiles;
    }
}
