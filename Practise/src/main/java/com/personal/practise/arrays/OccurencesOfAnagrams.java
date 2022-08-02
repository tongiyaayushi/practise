package com.personal.practise.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OccurencesOfAnagrams {

    int search(String pat, String txt) {
        List<Character> anaGramChars = new ArrayList<>();

        for (int i = 0; i< pat.length();i++)
            anaGramChars.add(pat.charAt(i));

        int anagramCount =0;
        int i =0;
        List<Character> anaGramCharsForComparison = new ArrayList<>();
        do {
            anaGramCharsForComparison.clear();
            anaGramCharsForComparison.addAll(anaGramChars);
            char ithChar = txt.charAt(i);
            boolean isContain = anaGramCharsForComparison.contains(ithChar);

            if(isContain) {
                inner:
                if (txt.length() >= i + pat.length()) {
                    for (int j = i; j < i + pat.length(); j++) {
                        Character charToBeChecked = txt.charAt(j);
                        boolean characterExistInPat = anaGramCharsForComparison.remove(charToBeChecked);
                        if (!characterExistInPat) {
                            i = i + pat.length() - 1;
                            break inner;
                        }
                    }
                    if (anaGramCharsForComparison.size() == 0) {
                        anagramCount++;
                    }
                } else{
                  return anagramCount;
                }
            }
            i++;
        } while (i < txt.length());
        return anagramCount;
    }


}
