package com.java.dataStructureStudy.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        int i = 0;
        while (flag) {
            flag = false;
            for (int j=arr.length-1; j >i ; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    flag = true;
                    System.out.println(Arrays.toString(arr));
                }
            }
            i++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
