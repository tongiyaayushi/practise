package com.personal.practise.stack;

import java.util.Stack;

public class ValidParanthesisString {

    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int starCount = 0;

        for (int i = 0 ; i < chars.length; i++){

            if (chars[i] == '(' )

                stack.push(chars[i]);

            else if (chars[i] == '*')

                starCount++;

            else if( !stack.isEmpty() && chars[i] == ')')

                    stack.pop();

            else if ( stack.isEmpty() && chars[i] == ')' && starCount > 0)

                starCount --;

            else
                return false;

        }

        if (stack.size() <= starCount)
            return true;

        return false;
    }

    public boolean checkValidStringAgain(String s) {
        char[] chars = s.toCharArray();
        int leftcount = 0, rightCount = 0;
        for (int i = 0 ; i < chars.length; i++){
            if (chars[i] == '(' || chars[i] == '*')
                leftcount++;
            else
                leftcount--;

            if(leftcount < 0) return false;
        }
        if (leftcount == 0)
            return true;

        for (int i = chars.length -1 ; i >= 0 ; i--){
            if (chars[i] == ')' || chars[i] == '*')
                rightCount++;
            else
                rightCount--;

            if(rightCount < 0) return false;
        }
        if (rightCount == 0)
            return true;

        return true;
    }
}
