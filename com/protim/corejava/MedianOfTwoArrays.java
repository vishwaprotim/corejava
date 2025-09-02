package com.protim.corejava;

import java.util.PriorityQueue;

public class MedianOfTwoArrays {

    // Assumptions:
    // All lowercase characters
    // Approach - Using Sliding Window

    public static void main(String[] args){

        int[] nums1 = {1,3,7};
        int[] nums2 = {2,4,5};
        double answer = findMedianSortedArrays(nums1, nums2);
        System.out.println("Answer is " + answer);


    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0){
            return medianOfArray(nums2);
        }
        if(nums2.length == 0){
            return medianOfArray(nums1);
        }

        int[] mergedArr = mergePQ(nums1, nums2);
        return medianOfArray(mergedArr);
    }


    static double medianOfArray(int[] arr){
        boolean even = arr.length % 2 == 0;
        return even? (double)(arr[arr.length/2] + arr[arr.length/2 - 1])/2 : arr[arr.length/2];
    }

    static int[] merge(int[] arr1, int[] arr2){
        int[] merged = new int[arr1.length + arr2.length];
        int i=0, j=0, m=0;

        while(m < merged.length){

            if(i >= arr1.length && j < arr2.length){
                // arr1 is exhausted. Copy everything from arr2 to merged array
                merged[m++] = arr2[j++];
                continue;
            }
            if(j >= arr2.length && i < arr1.length){
                // arr2 is exhausted. Copy everything from arr1 to merged array
                merged[m++] = arr1[i++];
                continue;
            }
            // Compare both arr1, arr2 and increment accordingly
            merged[m++] = (arr1[i] < arr2[j])? arr1[i++] : arr2[j++];


        }
        return merged;
    }

    static int[] mergePQ(int[] arr1, int[] arr2){
        PriorityQueue<Integer> merged = new PriorityQueue<>();
        for(var c: arr1){
            merged.add(c);
        }
        for(var c: arr2){
            merged.add(c);
        }
        int[] output = new int[merged.size()];
        int i = 0;
        while(!merged.isEmpty()){
            output[i++] = merged.poll();
        }
        return output;
    }

}
