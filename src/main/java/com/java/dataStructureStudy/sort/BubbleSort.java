package com.java.dataStructureStudy.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        bubbleSort(arr);
    }
    public static void bubbleSort(int[] arr){
        boolean flag=true;
        while(flag){
            flag=false;
            for(int i=arr.length-1;i>0;i--){
                if(arr[i-1]>arr[i]){
                    swap(arr,i-1,i);
                    flag=true;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
