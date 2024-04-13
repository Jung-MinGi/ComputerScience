package com.java.dataStructureStudy.collection;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;//최소 용적
    private static final Object[] EMPTY_ARRAY = {};

    private int size;//arrayList안의 요소개수를 의미
    Object[] array;

    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }


    private void resize() {
        if (Arrays.equals(array, EMPTY_ARRAY)) {//array 크기가 0인 상태이면
            array = new Object[DEFAULT_CAPACITY];//최소용적크기를 가지는 배열로 생성해준다.
            return;
        }

        int length = array.length;

        if (size == length) {//배열이 꽉 찬 상태이면 array의 크기를 두 배 크게해준다.
            array = Arrays.copyOf(array, length * 2);
            return;
        }
        if (size < length / 2) {//배열안의 요소사 크기의 절반보다 작을때
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, length / 2));
        }
    }

    @Override
    public boolean add(E value) {
        return false;
    }

    public void addLast(E value) {
        if (array.length == size) {//배열크기와 요소의 개수가 일치하면 추가할 공간이 없는상태이므로
            resize();//배열의 크기를 늘려준다.
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(int index, E value) {
        if (index < 0 || index >= array.length) {//index위치가 범위를 벗어나는 경우 예외를 던진다
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {//삽입할 위치가 맨 뒤인경우 addLast()호출
            addLast(value);
            return;
        }

        if (size == array.length) {//배열크기와 요소개수가 동일한 상태면 중간삽입이 불가능하니깐 크기 재조정해줘야한다
            resize();
        }

        for (int i = size - 1; i >= index; i--) {//뒤에서부터 삽입할 위치까지 모든 값을 한칸 뒤로 옮김;
            array[i + 1] = array[i];
        }
        array[index] = value;
        size++;
    }

    public void addFirst(E value) {
        add(0, value);
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {//index위치가 범위를 벗어나는 경우 예외를 던진다
            throw new IndexOutOfBoundsException();
        }
        E ret = (E) array[index];
        array[index] = null;
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }
        size--;
        return ret;
    }

    @Override
    public boolean remove(Object value) {
        int i = indexOf(value);
        if (i >= 0) {
            remove(i);
            return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {//index위치가 범위를 벗어나는 경우 예외를 던진다
            throw new IndexOutOfBoundsException();
        }

        return (E) array[index];
    }

    @Override
    public void set(int index, E value) {
        if (index < 0 || index >= size) {//index위치가 범위를 벗어나는 경우 예외를 던진다
            throw new IndexOutOfBoundsException();
        }
        array[index] = value;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (value.equals(array[i])) return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        for(int i=0;i<size;i++)array[i]=null;
        size=0;
        resize();
    }
}
