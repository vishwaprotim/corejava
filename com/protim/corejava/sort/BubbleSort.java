package com.protim.corejava.sort;

import static com.protim.corejava.ArrayUtils.printArray;

public class BubbleSort {

    /*
        Check the details and write up here:
        https://github.com/vishwaprotim/corejava/wiki/01.-Bubble-Sort
     */


    public static int[] bubbleSort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }
        for(int j = 0; j < arr.length - 1 ; j++){
            boolean swapped = false;
            for(int i = 0; i < arr.length - 1 - j; i++){
                if(arr[i] > arr[i +1]) {
                    // swap these
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    swapped = true;
                }
            }
            if(!swapped){
                // No swapping in current iteration, i.e., the array has been sorted
                return arr;
            }
        }

        return arr;
    }



    public static void main(String[] args){
        // run the code
        int[] arr = new int[]{4,3,2,1,0,12,11, 14, 13, -1, -2, 3, 6};
        printArray(arr);
        System.out.println("Sorted array: ");
        bubbleSort(arr);
        printArray(arr);

    }

}
