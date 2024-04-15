package com.java.dataStructureStudy.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,4,6,1,3};
        InsertionSort a = new InsertionSort();
        a.insertionSort(arr);
    }
    public void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int v = arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>v){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=v;
            System.out.println(Arrays.toString(arr));
        }
    }
}
/**
 * [결과]
 * [2, 5, 4, 6, 1, 3]
 * [2, 4, 5, 6, 1, 3]
 * [2, 4, 5, 6, 1, 3]
 * [1, 2, 4, 5, 6, 3]
 * [1, 2, 3, 4, 5, 6]
 */