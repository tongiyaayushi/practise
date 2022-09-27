package com.personal.practise.arrays;

import java.util.ArrayList;
import java.util.List;

public class GroupingOfAnagrams {

    public boolean isAnagram(String a, String b) {
        boolean isAnagram = false;
        List<Character> chars = new ArrayList<>();
        if (a.length() != b.length())
            return isAnagram;

        for (int i = 0; i < a.length(); i++) {
            chars.add(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {

            if (chars.contains(b.charAt(i)))
                chars.remove(chars.indexOf(b.charAt(i)));
            else
                break;
        }

        if (chars.size() == 0)
            isAnagram = true;

        return isAnagram;
    }

    public List<List<String>> generateAnagrams(String[] string_list) {

        List<List<String>> anagramGroups = new ArrayList<>();
        List<Integer> indexesCovered = new ArrayList<>();

        for (int i = 0; i < string_list.length; i++) {

            List<String> anagrams = new ArrayList<>();
            anagrams.add(string_list[i]);

            if (indexesCovered.size() > 0 && indexesCovered.contains(i))
                continue;

            for (int j = i + 1; j < string_list.length; j++) {

                if (isAnagram(string_list[i], string_list[j])) {
                    anagrams.add(string_list[j]);
                    indexesCovered.add(j);
                }

            }
            anagramGroups.add(anagrams);
        }

       return anagramGroups;
    }
}
