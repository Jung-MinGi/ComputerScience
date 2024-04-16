package com.java.dataStructureStudy.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        selectionSort(arr);
    }
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
