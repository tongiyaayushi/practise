package com.personal.practise.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNonRepeatingCharacterStream {

    public String FirstNonRepeating(String A)
    {
        char[] chars = A.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        List<Character> charactersalreadyTraversed = new ArrayList<>();
        for(int i = 0; i <  A.length(); i++){
            if(!queue.isEmpty() && queue.contains(chars[i])){

                queue.remove(chars[i]);
                charactersalreadyTraversed.add(chars[i]);

            } else if(!charactersalreadyTraversed.contains(chars[i]))
                    queue.add(chars[i]);

            //String concat = ;
            str.append(queue.isEmpty() ? "#" : queue.peek());

        }
        return str.toString();
    }
}
