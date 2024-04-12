package com.java.dataStructureStudy.collection.stack;

public interface StackInterface<E>{
    E push(E value);
    E pop();
    E peek();
    int search(Object value);
    int size();
    void clear();
    boolean empty();
}
