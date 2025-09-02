package com.protim.corejava;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    // Assumptions:
    // All lowercase characters
    // Approach - Using Sliding Window

    public static void main(String[] args){

        String testData = "pwwkew";
        System.out.println("Input: " + testData);
        int answer = longestSubstringWithoutRepeatingCharacters(testData);
        System.out.println("Answer is " + answer);
    }


    public static int longestSubstringWithoutRepeatingCharacters(String s){
        char[] arr = s.toCharArray();
        if(arr.length <=1){
            return arr.length;
        }

        // Window, start and end
        Map<Character, Integer> window = new HashMap<>();
        int start=0;
        int end=0;

        int max = 0;
        for(int i=0; i<arr.length; i++){
            if(window.containsKey(arr[i]) && window.get(arr[i]) >= start){
                start = window.get(arr[i]) + 1;
            }

            window.put(arr[i], i);
            end++;
            max = Math.max(end-start, max);
        }
        return max;
    }

}
