package com.java.dataStructureStudy.collection.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void test(){
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=10;i++)stack.push(i);
        System.out.println(stack.search(5));
        Assertions.assertThat(stack.search(10)).isEqualTo(1);
    }

}