package com.personal.practise;

import java.util.Arrays;
import java.util.List;

public class Practise {
    public static void main(String[] args) {

        //Problem 1
        List<Long> rectangle1 = List.of((long) 2, (long) 3);
        List<Long> rectangle2 = List.of((long) 1, (long) 2);
        List<Long> rectangle3 = List.of((long) 16, (long) 24);
        List<Long> rectangle4 = List.of((long) 100, (long) 200);
        List<List<Long>> rectangleSides = List.of(rectangle1, rectangle2, rectangle3, rectangle4);
        NearlySimilarRectanglesSolution findNearlySimilarRectangles = new NearlySimilarRectanglesSolution();
        System.out.println("The number of nearly similar rectangles are " + findNearlySimilarRectangles.findNearlySimilarRectangles(rectangleSides));

        // Problem 2
        MinimumTimeToProcessFilesGivenNCoresAndLimitOfParalellExecution minTimeFinder = new MinimumTimeToProcessFilesGivenNCoresAndLimitOfParalellExecution();
        List<Integer> files = Arrays.asList(4,3,1,2,8);
        List<Integer> files1 = Arrays.asList(2,3,1,5);
        System.out.println("Minimum Time to process files with given lines provided No of cores and limit of number of files that can run in paraller"
                + minTimeFinder.findMinimumTime(5,5,files1));

        //Problem3
        LengthOfLongestSubStringWithoutRepeatatingCharacters lengthOfLongestSubStr = new LengthOfLongestSubStringWithoutRepeatatingCharacters();
        System.out.println("Lenth of longest sub string without repeatating characters is "
                + lengthOfLongestSubStr.longestUniqueSubsttr("ABDEFGABEF"));

        // Problem 4 : Minimum number of jumps to reach end
        MinNumOfJumpsToReachEnd minJumpsFinder = new MinNumOfJumpsToReachEnd();
        //int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Minimum number of jumps to reach the end given the array of Jumps is " + minJumpsFinder.minNumOfJumps(arr));

        // Problem 5 : Reverse a Linked List in groups of given size
        ReverseNodesOfLinkedList llist = new ReverseNodesOfLinkedList();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);
            llist.head = llist.reverse(5, llist.head);
            llist.printList();
    }


}
