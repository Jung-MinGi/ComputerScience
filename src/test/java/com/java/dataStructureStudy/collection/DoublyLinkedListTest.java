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
    @DisplayName("remove")
    public void removeTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        doublyLinkedList.remove();
        Node<Integer> node = (Node<Integer>) getMethod().invoke(doublyLinkedList, 0);
        Assertions.assertThat(node.data).isEqualTo(2);

        doublyLinkedList.remove(5);
        Node<Integer> node2 = (Node<Integer>) getMethod().invoke(doublyLinkedList, 5);
        Assertions.assertThat(node2.data).isEqualTo(8);

        Assertions.assertThat(doublyLinkedList.size()).isEqualTo(8);

    }
}