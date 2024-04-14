package com.java.dataStructureStudy.collection.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    ArrayQueue<Integer> queue =new ArrayQueue<>();
    @BeforeEach
    void init(){
        for(int i=1;i<=10;i++)queue.offer(i);
    }

    @Test
    @DisplayName("contains메서드 테스트")
    void test1(){
        Assertions.assertThat(queue.contains(9)).isTrue();
        Assertions.assertThat(queue.contains(11)).isFalse();
    }
    @Test
    @DisplayName("peek메서드 테스트")
    void test2(){
       for(int i=1;i<10;i++)Assertions.assertThat(queue.peek()).isEqualTo(1);
    }
    @Test
    @DisplayName("poll메서드 테스트")
    void test3(){
       for(int i=1;i<=10;i++)Assertions.assertThat(queue.poll()).isEqualTo(i);
    }


}