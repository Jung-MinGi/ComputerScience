package com.java.dataStructureStudy.collection.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 64;//배열의 최소크기
    private Object[] array;
    private int size;//배열안 요소의 개수
    private int front = 0;
    private int rear = 0;

    public ArrayQueue() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapa) {
        int currentLen = array.length;//현재 큐의 크기

        Object[] newArray = new Object[newCapa];//새로운 배열 생성
        int idx = front + 1;
        for (int i = 1; i <= size; i++) {
            newArray[i] = array[idx % currentLen];
            idx++;
        }
        array = newArray;
        front = 0;
        rear = size;
    }

    @Override
    public boolean offer(E value) {
        if ((rear + 1) % array.length == front) {
            resize(array.length * 2);
        }
//        rear++;
        rear = (rear + 1) % array.length;
        array[rear] = value;
        size++;

        return true;
    }

    @Override
    public E poll() {

        if (size == 0) return null;//배열안에 요소가 없는 경우

        front = (front + 1) % array.length;
        E ret = (E) array[front];
        array[front] = null;
        size--;
        /**
         * 배열의 요소를 제거했으므로 공간낭비가 생기지 않게 배열의 크기를 재조정
         * 배열안의 요소개수가 전체크기의 1/4미만인경우 크기를 줄인다
         */
        if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
            //크기를 아무리 줄여도 최소크기값보다 작게 줄이지 않게 Math.max()를 해준다
            resize(Math.max(DEFAULT_CAPACITY, array.length / 4));
        }
        return ret;
    }

    public E remove() {
        E poll = poll();
        if (poll == null) {
            throw new NoSuchElementException();
        }
        return poll;
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw null;
        }
        front = (front + 1) % array.length;
        return (E) array[front];
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean contains(Object value ){
        for(int i=front+1;i<=rear;i++){
            if(array[i%array.length].equals(value))return true;
        }
        return false;
    }
    public void clear(){
        for(int i=front+1;i<=rear;i++){
            array[i%array.length]=null;
        }
        size=0;
        front=0;
        rear=0;
    }
}
