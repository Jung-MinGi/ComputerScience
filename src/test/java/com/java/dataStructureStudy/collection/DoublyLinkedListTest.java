package com.java.dataStructureStudy.collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DoublyLinkedListTest {
    DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

    @BeforeEach
    void init() {
        for (int i = 1; i <= 10; i++) {
            doublyLinkedList.add(i);
        }
    }

    @Test
    @DisplayName("search")
    void searchTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Node<Integer> invoke = (Node<Integer>) getMethod().invoke(doublyLinkedList, 0);
        Assertions.assertThat(invoke.data).isOne();
    }

    private Method getMethod() throws NoSuchMethodException {
        Method method = DoublyLinkedList.class.getDeclaredMethod("search", int.class);
        method.setAccessible(true);
        return method;
    }

    @Test
    @DisplayName("remove()")
    public void removeTest1() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        doublyLinkedList.remove();
        Node<Integer> node = (Node<Integer>) getMethod().invoke(doublyLinkedList, 0);
        Assertions.assertThat(node.data).isEqualTo(2);


    }

    @Test
    @DisplayName("remove(int index)")
    public void removeTest2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        doublyLinkedList.remove(5);
        Node<Integer> node = (Node<Integer>) getMethod().invoke(doublyLinkedList, 5);
        Assertions.assertThat(node.data).isEqualTo(7);

        Assertions.assertThat(doublyLinkedList.size()).isEqualTo(9);
    }
    @Test
    @DisplayName("remove(E value)")
    public void removeTest3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //리스트 중간에 값 바꿔치기
        doublyLinkedList.set(5,45);
        Node<Integer> node = (Node<Integer>) getMethod().invoke(doublyLinkedList, 5);
        Assertions.assertThat(node.data).isEqualTo(45);

        doublyLinkedList.remove((Object) 45);
        Node<Integer> ret = (Node<Integer>) getMethod().invoke(doublyLinkedList, 5);
        Assertions.assertThat(ret.data).isNotEqualTo(45);

        Assertions.assertThat(doublyLinkedList.size()).isEqualTo(9);
    }
}