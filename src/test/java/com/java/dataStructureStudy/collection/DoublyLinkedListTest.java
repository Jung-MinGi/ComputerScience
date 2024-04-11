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
//            System.out.println("i = " + i);
            doublyLinkedList.add(i);
        }

    }

    @Test
    @DisplayName("search")
    void searchTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = DoublyLinkedList.class.getDeclaredMethod("search", int.class);
        method.setAccessible(true);
        Node<Integer> invoke = (Node<Integer>) method.invoke(doublyLinkedList, 0);
        Assertions.assertThat(invoke.data).isOne();
    }

    @Test
    @DisplayName("remove")
    public void removeTest() {


    }
}