package com.example.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }
}
