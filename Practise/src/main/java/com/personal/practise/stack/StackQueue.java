package com.personal.practise.stack;

import java.util.Stack;

public class StackQueue {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    //Function to push an element in queue by using 2 stacks.
    public void Push(int x)
    {
        while ( !s1.isEmpty() ){
            s2.push(s1.pop());
        }
        s1.push(x);
    }

    //Function to pop an element from queue by using 2 stacks.
    public int Pop()
    {
        while ( !s2.isEmpty() ){
            s1.push(s2.pop());
        }
        return s1.isEmpty() ? 0 : s1.pop();
    }
}
