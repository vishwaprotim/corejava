package com.protim.corejava;

import java.util.*;

public class ThreeSum {

    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
    such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.
    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.
    Example 2:

    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.
    Example 3:

    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.
    */


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        // This will ensure we are handling duplicate values and are able to use a two pointer approach
        // say given test data is -1,0,1,2,-1,-4
        // Now it is -4, -1, -1, 0, 1, 2
        for(int i = 0; i < nums.length; i++){
            int complement = nums[i] * -1;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[j] + nums[k];
                if(complement == sum){
                    // found it
                    triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // If the next number is duplicate, skip it
                    while(j+1 < nums.length && nums[j] == nums[j+1]) j++;
                    while(k > 1 && nums[k] == nums[k-1]) k--;
                    j++; k--; // to ensure overflow happens when condition is met
                }
                if(sum < complement) j++;
                if(sum > complement) k--;
            }
            // If the next number is a duplicate, skip it
            if(nums[i] == nums[i+1]) i++;
        }

        return triplets;
    }


    public static void main(String[] args){
        // run the code
        int[] nums = new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        System.out.println("Three Sum of nums is " + threeSum(nums));
    }

}
