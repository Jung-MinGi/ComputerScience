package com.java.dataStructureStudy.collection;

public class Node<E>{
    E data;//저장할 데이터
    Node<E> nextNode;//다음 노드를 가리킨다
    Node<E> prevNode;//이전 노드를 가리킨다
    public Node(E data) {
        this.data = data;
        this.nextNode = null;
        this.prevNode = null;
    }
}
