package com.protim.corejava.sort;

import static com.protim.corejava.ArrayUtils.printArray;

public class InsertionSort {

    /*
        Check the details and write up here:
        https://github.com/vishwaprotim/corejava/wiki/Sorting-Algorithms#1-insertion-sort
     */

    public static int[] insertionSort(int[] arr){
        if(arr.length <= 1) return arr;

        for(int j = 1; j < arr.length; j++){
            int key = arr[j];
            int i = j-1;
            while(i >= 0 && arr[i] > key){
                arr[i+1] = arr[i--];
            }
            arr[i+1] = key;
        }

        return arr;

    }

    public static void main(String[] args){
        // run the code.
        int[] testData = new int[]{14,12,5,2,3,1,9,8,0,-2,33,-5};
        printArray(testData);
        insertionSort(testData);
        System.out.println("Sorted array is:");
        printArray(testData);

    }

}
