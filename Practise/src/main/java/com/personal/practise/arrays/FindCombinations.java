//package com.personal.practise.arrays;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FindCombinations {
//    public List<String> findCombinations(String input){//input = "abcd"
//        List<String> combinations	= new ArrayList<String>;
//        char[] inputChars = input.charArray();
//
//
//        for(int i = input.length()-1; i >= 0; i--){
//            char swap = inputChars[i];
//            char[] in = inputChar;
//            for (int j = i-1; j >= 0; j--){
//                char swapWith = in[j];
//                in = swap(swap,swapWith);
//                String combination =  inputChars.toString();
//                combinations.add(combination);
//            }
//        }
//        combinations.add(input);
//        return combinations;
//    }
//
//    public void swap(char a, char b){
//        char temp = a;
//        a = b;
//    }
//
//}
