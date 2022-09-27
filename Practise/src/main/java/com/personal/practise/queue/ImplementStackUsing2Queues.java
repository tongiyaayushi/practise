package com.personal.practise.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsing2Queues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    //Function to push an element into stack using two queues.
    public void push(int a)
    {
        if(q1.isEmpty() && q2.isEmpty())
            q1.add(a);

        else if(q1.isEmpty() && !q2.isEmpty()){
            q1.add(a);
            while(!q2.isEmpty())
                q1.add(q2.poll());
        }

        else if(!q1.isEmpty() && q2.isEmpty()) {
            q2.add(a);
            while(!q1.isEmpty())
                q2.add(q1.poll());
        }
    }

    //Function to pop an element from stack using two queues.
    public int pop()
    {
        if(q1.isEmpty() && !q2.isEmpty())
            return q2.poll();
        else if(q2.isEmpty() && !q1.isEmpty())
            return q1.poll();
        else
            return -1;

    }

}
