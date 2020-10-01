package com.rexijie.algorithms;

import java.util.Arrays;

public class Sort {
    private static void swap (int[] arr, int idx1, int idx2) {
        int temp;
        temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void bubbleSort(int[] arr) {
        boolean swapTriggered;
        int passes = 0;
        for (int j = 0; j < arr.length; j++) {
            swapTriggered = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    swapTriggered = true;
                }
            }
            passes++;
            if (!swapTriggered) break;
        }
        System.out.println(passes);
    }

    private static int partition(int[] arr, int low, int high) {
        return 0;
    }

    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        if (low == high) return;
        partition(arr, low, high);
    }

    public static void main(String[] args) {
        var arr = new int[] {2,6,3,5,8,45,6,2,1};
        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
