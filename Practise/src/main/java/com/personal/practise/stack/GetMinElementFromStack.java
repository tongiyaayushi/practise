package com.personal.practise.stack;

import java.util.Stack;

public class GetMinElementFromStack {
    int minEle= Integer.MAX_VALUE;
        Stack<Integer> s = new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
        return s.isEmpty() ? -1 : minEle;
    }

    /*returns poped element from stack*/
    int pop()
    {
        int x = s.isEmpty() ? -1 : s.pop();

        if(s.isEmpty())
            minEle = Integer.MAX_VALUE;

        if(minEle == x){
            minEle = Integer.MAX_VALUE;
           for (int a : s)
               minEle = Math.min(minEle, a);
        }
        return x;
    }

    /*push element x into the stack*/
    void push(int x)
    {
        minEle = Math.min(minEle, x);
        s.push(x);
    }
}
