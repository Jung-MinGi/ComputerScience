package com.java.dataStructureStudy.collection.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {
    private static final int DEFAULT_CAPACITY = 10;//최소 스택의 크기
    private static final Object[] EMPTY_ARRAY = {};//빈 배열
    private Object[] array;//요소를 담을 배열
    private int size;//스택안에 들어있는 요소의 개수

    public Stack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    private void resize() {
        if (Arrays.equals(array, EMPTY_ARRAY)) {//스택안에 요소가 없을때
            array = new Object[DEFAULT_CAPACITY];//최소용적크기로 세팅
            return;
        }
        int length = array.length;
        if (length == size) {//스택안에 빈공간이 없을때
            int newSize = length * 2;//현재크기의 두배로 늘린다.
            array = Arrays.copyOf(array, newSize);
            return;
        }
        if (length / 2 > size) {//현재 크기의 절반보다 요소의 개수가 적을때
            int newSize = length / 2;//스택 사이즈를 절반으로 줄인다.
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newSize));
        }
    }


    @Override
    public E push(E value) {
        if (size == array.length) {//스택안에 데이터가 꽉 찬 상태이면 크기조정해야함
            resize();
        }
        array[size] = value;
        size++;
        return value;
    }
    @Override
    public E pop() {
        if (size == 0) {//pop할 요소가 없으면 예외를 던진다.
            throw new EmptyStackException();
        }
        E ret = (E) array[size - 1];
        array[size - 1] = null;
        size--;

        resize();//요소 제거후 크기 재조정
        return ret;//pop요소 반환
    }

    @Override
    public E peek() {
        if (size == 0) {//peek할 요소가 없으면 예외를 던진다.
            throw new EmptyStackException();
        }

        return (E) array[size - 1];//peek요소 반환
    }

    @Override
    public int search(Object value) {
        if(value==null){
            for(int i=size-1;i>=0;i--){
                if(array[i]==null){
                    return size-i;
                }
            }
        }else{
            for(int i=size-1;i>=0;i--){
                if(array[i].equals(value)){
                    return size-i;
                }
            }
        }
        return -1;//찾고자 하는 value값이 스택에 없는경우
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(int i=0;i<size;i++){
            array[i]=null;
        }
        size=0;
        resize();
    }

    @Override
    public boolean empty() {
        return size==0;
    }
}
