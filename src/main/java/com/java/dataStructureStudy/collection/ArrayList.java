package com.java.dataStructureStudy.collection;

import java.util.Arrays;

public class ArrayList  {
    private static final int DEFAULT_CAPACITY = 10;//기본 용적
    private static final Object[] EMPTY_ARRAY = {};

    private int size;//arrayList안의 요소개수를 의미
    Object[] array;

    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }


    //동적할당을 위한 resize메서드
    //들어오는 데이터에 따라 최적화된 크기를 가지기위해서 필요함
    //요소에 비해 용적이 너무크면 공간낭비가 되니깐
    private void resize() {
        int array_capacity = array.length;


        if (Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        //용적이 다 찬 경우
        if (size == array_capacity) {
            int new_Capacity = array_capacity * 2;

            array = Arrays.copyOf(array, new_Capacity);
            return;
        }

        //데이터개수에 비해 용적이 너무 큰경우
        //데이터가 전체크기의 절반보다 적은 경우
        if (size < array_capacity / 2) {
            int new_Capacity = array_capacity / 2;
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, new_Capacity));
            return;
        }
    }
}
