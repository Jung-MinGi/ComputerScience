package com.java.dataStructureStudy.collection;

public interface List<E> {

    boolean add(E value);

    void add(int index, E value);

    E remove(int index);

    boolean remove(Object value);

    E get(int index);
    void set(int index,E value);
    boolean contains(E value);
    int indexOf(E value);
    int size();
    boolean isEmpty();
    public void clear();
}
