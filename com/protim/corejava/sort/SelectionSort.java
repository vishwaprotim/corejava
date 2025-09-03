package com.protim.corejava.sort;

import static com.protim.corejava.ArrayUtils.printArray;

public class SelectionSort {

    /*
        Check the details and write up here:
        https://github.com/vishwaprotim/corejava/wiki/02.-Selection-Sort
     */


    public static int[] selectionSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }

        for(int j = 0; j < arr.length -1; j++){
            int minIndex = j; // The first element of unsorted elements is considered minimum
            for(int i = j+1; i < arr.length; i++){
                if(arr[i] < arr[minIndex]){
                    minIndex = i;
                }
            }
            if(minIndex != j){
                // Swap the minIndex with the first element of the unsorted elements
                int temp = arr[j];
                arr[j] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }


    public static void main(String[] args){
        // run the code
        int[] arr = new int[]{4,3,2,1,0,12,11, 14, 13, -1, -2, 3, 6};
        printArray(arr);
        System.out.println("Sorted array: ");
        selectionSort(arr);
        printArray(arr);

    }

}
