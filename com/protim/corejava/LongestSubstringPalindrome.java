package com.protim.corejava;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringPalindrome {

    static Set<String> palindromes = new HashSet<>();
    static String max = "";

    public static boolean checkPalindrome(String s){
        if(palindromes.contains(s)){
            return true;
        }


        if(s.length() == 1 || (s.length() == 2 && s.charAt(0) == s.charAt(1))){
            palindromes.add(s);
            return true;
        }

        if(s.charAt(0) == s.charAt(s.length()-1)){
            String testcase = s.substring(1, s.length()-1);
            if(palindromes.contains(testcase)){
                palindromes.add(s);
                return true;
            }
            if(new StringBuilder(testcase).reverse().toString().equals(testcase)){
                palindromes.add(testcase);
                palindromes.add(s);
                return true;
            }
            return false;
        }

        // Not a palindrome
        return false;
    }



    public static String longestPalindrome1(String s) {
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == s.charAt(i)){
                    String testData = s.substring(i, j+1);
                    boolean isPalindrome = checkPalindrome(testData);
                    if(isPalindrome){
                        max = max.length() < testData.length()? testData : max;
                        // max = max.length() < j+ 1 - i ? testData : max;
                    }
                }
            }
        }
        return max;
    }


    public static void helper(String s, char[] arr, int center) {

        int l = center;
        int r = arr.length % 2 == 0? l + 1 : l;

        System.out.println("Center: " + center + ", Left: " + l + ", Right: " + r);

        while(arr[l] == arr[r]){
            // keep expanding the range
            l -- ;
            r ++ ;
            if(l <= 0) l = 0;
            if(r >= arr.length) r=arr.length-1;
        }
        l++;r--;

        max = max.length() > r - l + 1 ? max : s.substring(l, r + 1);
    }

    public static String longestPalindrome(String s){
        if(s.length() <= 1){
            return s;
        }

        char[] arr = s.toCharArray();

        for(int i = 0; i< arr.length; i++){
            helper(s, arr, i);
        }
        return max;
    }

    public static void main(String[] args){
        String testData = "ccc";
        System.out.println("Answer is: " + longestPalindrome(testData));
    }



}
