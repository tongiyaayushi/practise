package com.personal.practise.queue;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {

    public int tour(int petrol[], int distance[])
    {
        Queue<Integer> startingPointCandidatePumps = new LinkedList<>();

        int noOfPumps = petrol.length;

       for(int i = 0; i < noOfPumps; i++){
           if(petrol[i] >= distance[i])
               startingPointCandidatePumps.add(i);
       }

       if (startingPointCandidatePumps.size() == 0)
           return -1;


       while ( !startingPointCandidatePumps.isEmpty()){
           int i = startingPointCandidatePumps.poll();
           int j = i;
           int petrolLeft = petrol[i] - distance[i];
           i++;

           while (i != j){
                   if( i > noOfPumps -1 && j > 0)
                       i = 0;

                   if (i > noOfPumps -1 && j == 0){
                       i = 0;
                       break;
                   }

                    petrolLeft += petrol[i] - distance[i];

                   if (petrolLeft < 0) {
                       System.out.println("Starting at "+ j +" Petrol drained at i= "+ i);
                       break;
                   }

                   i++;
           }
           if(i == j)
                return j;
           }

        return -1;
    }

    public int tourOptimized(int petrol[], int distance[])
    {

        int noOfPumps = petrol.length;
        int petrolLeft = 0, startingPoint = 0, requiredPetrol = 0;
        for( int i =0; i < noOfPumps; i++) {
             petrolLeft += petrol[i] - distance[i];

             if (petrolLeft < 0){
                 requiredPetrol += petrolLeft;
                 startingPoint = i+1;
                 petrolLeft = 0;
             }
        }

        return petrolLeft + requiredPetrol > 0 ? startingPoint : -1;
    }
}
