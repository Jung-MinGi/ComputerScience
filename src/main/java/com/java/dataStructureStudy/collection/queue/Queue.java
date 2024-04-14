package com.java.dataStructureStudy.collection.queue;

public interface Queue<E> {
    boolean offer(E value);
    E poll();

    E peek();
}
