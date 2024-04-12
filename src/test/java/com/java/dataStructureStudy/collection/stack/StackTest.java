package com.java.dataStructureStudy.collection.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StackTest {

    @Test
    @DisplayName("push메서드")
    void pushTest() {
        Stack<Integer> stack = new Stack<>();
        setUp(stack);
    }
    @Test
    @DisplayName("pop메서드")
    void popTest() {
        Stack<Integer> stack = new Stack<>();
        setUp(stack);
        for (int i = 10; i >=1; i--){
            Integer pop = stack.pop();
            Assertions.assertThat(pop).isEqualTo(i);
        }
    }
    @Test
    @DisplayName("peek메서드")
    void peekTest() {
        Stack<Integer> stack = new Stack<>();
        setUp(stack);
        for (int i = 10; i >=1; i--){
            Integer peek = stack.peek();
            Assertions.assertThat(peek).isEqualTo(10);
        }
    }

    private static void setUp(Stack<Integer> stack) {
        for (int i = 1; i <= 10; i++){
            stack.push(i);
        }
    }

}