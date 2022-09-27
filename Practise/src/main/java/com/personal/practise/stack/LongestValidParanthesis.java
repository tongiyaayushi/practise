package com.personal.practise.stack;

import java.util.Stack;

public class LongestValidParanthesis {
    public int maxLength(String S){
        int maxLength = 0;
        char[] chars = S.toCharArray();
        int n = S.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0 ; i < chars.length; i++) {
            if (chars[i] == '(')
                stack.push(i);
            else if (chars[i] == ')' && stack.peek() != -1 && chars[stack.peek()] == '(')
                stack.pop();
            else
                stack.push(i);
        }

        if(stack.peek() == -1)
            return n;

        while (!stack.isEmpty()){

            int lastInvalidParanthesisIndex = stack.pop();

            if (n-lastInvalidParanthesisIndex == 1) {
                n = lastInvalidParanthesisIndex;
                continue;
            }
            maxLength = Math.max(maxLength, n-lastInvalidParanthesisIndex-1);
            n = lastInvalidParanthesisIndex;
        }
        return maxLength;
    }
}
