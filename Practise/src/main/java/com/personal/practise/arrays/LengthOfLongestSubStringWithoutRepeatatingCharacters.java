package com.personal.practise.arrays;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubStringWithoutRepeatatingCharacters {

    public int findLengthOfLongestSubStringWithoutRepeatatingCharacters(String input){
        List<Character> charactersList = new ArrayList<>();
        int maxLengthWithoutRepetation = 0;
        input = input.toLowerCase();
        for (int i = 0 ; i < input.length() - maxLengthWithoutRepetation ; i++){
            if(charactersList.contains(input.charAt(i))){
                if (charactersList.size() > maxLengthWithoutRepetation) {
                    maxLengthWithoutRepetation = charactersList.size();
                }
                    charactersList.clear();
            } else {
                charactersList.add(input.charAt(i));
            }
        }
        return maxLengthWithoutRepetation;
    }

    public static int longestUniqueSubsttr(String str)
    {
        String test = "";

        // Result
        int maxLength = -1;

        // Return zero if string is empty
        if (str.isEmpty()) {
            return 0;
        }
        // Return one if string length is one
        else if (str.length() == 1) {
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);

            // If string already contains the character
            // Then substring after repeating character
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current)
                        + 1);
            }
            test = test + String.valueOf(c);
            maxLength = Math.max(test.length(), maxLength);
        }

        return maxLength;
    }

}
