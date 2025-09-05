package com.protim.corejava.binary;

import java.text.MessageFormat;

public class IntegerToBinary {

    /*
    Problem Statement: Convert Integer to Binary String

    e.g., input = 25, output = "11001"

    Approach 1: Using the built-in method from Integer Class
    Integer.toBinaryString()

    Approach 2: Division by 2
        [*] Divide the number by 2 and collect the remainder
        [*] Set the quotient as the dividend
        [*] Insert the remainder to the beginning of the output string
        [*] Repeat the process till quotient is 0
     */

    public static String toBinaryStringBuiltIn(int num){
        return Integer.toBinaryString(num); // Using built-int method
    }

    public static String toBinaryString(int num){
        if(num == 0) return "0";
        if(num == 1) return "1";

        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int bit  = num % 2;
            sb.insert(0, bit);
            num = num / 2;
        }

        return sb.toString();
    }

    public static void main(String[] args){
        // run the code
        int testData = 25;
        System.out.println(MessageFormat.format("The binary for {0} is {1}", testData, toBinaryStringBuiltIn(testData)));
        System.out.println(MessageFormat.format("The binary for {0} is {1}", testData, toBinaryString(testData)));
    }
}
