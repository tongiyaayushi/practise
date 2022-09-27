package com.personal.practise.arrays;

import java.util.ArrayList;
import java.util.List;

public class findAllPermutationOfAString {

    ArrayList<String> combinations = new ArrayList<>();

    public List<String> findPermutation(String S) {
        permutations(S,"");
        return combinations;
    }

    public void permutations(String s, String perm){
        if( s.length() == 0){
            combinations.add(perm);
            return;
        }

        for(int i = 0; i < s.length() ; i++){
            // fix a char at first position
            char c = s.charAt(i);
            // remove this char for the other positions
            String newStr = s.substring(0,i) + s.substring(i+1);
            permutations(newStr,perm+c);
        }
    }
}
