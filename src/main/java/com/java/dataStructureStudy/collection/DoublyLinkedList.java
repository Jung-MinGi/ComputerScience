package com.java.dataStructureStudy.collection;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index) {
        //찾으려는 index가 범위를 벗어난 경우
        if (index < 0 || index >= size) throw new NoSuchElementException();
        Node<E> x = null;
        if (index < size / 2) {//head부터 탐색
            x = head;
            for (int i = 0; i < index; i++) {
                x = x.nextNode;
            }
            return x;
        } else {//tail부터 탐색
            x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prevNode;
            }
            return x;
        }
    }

    public void addFirst(E value) {
        Node<E> node = new Node<>(value);

        node.nextNode = head;//새로만든 노드의 nextNode에 head를 연결

        if (head != null) {//nullpoint방지
            head.prevNode = node;//기존의head의 prevNode에 새로 추가될 노드 연결
        }
        head = node;//head노드를 새로운노드로 바꿔줌
        size++;
        //head의 다음 노드가 없는경우 사이즈가 1이므로
        //head와tail이 동일한 노드를 가리키게 만들어야됨
        if (head.nextNode == null) {
            tail = head;
        }
    }

    public void addLast(E value) {
        if (size == 0) {//리스트가 빈상태면 addFirst를 사용해도 문제없음
            addFirst(value);
            return;
        }
        Node<E> newNode = new Node<>(value);//추가할 노드 생성

        tail.nextNode = newNode;//기존 tail노드의 nextNode값에 새로운 노드 연결
        newNode.prevNode = tail;//새로운 노드의 prevNode값에 기존의 tail노드 연결
        tail = newNode;//tail에 새로운 노드로 변경
        size++;//요소 개수 ++
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node<E> targetNode = search(index);
        Node<E> node = new Node<>(value);
        Node<E> nextNode = targetNode.nextNode;
        targetNode.nextNode = node;
        nextNode.prevNode = node;
        node.prevNode = targetNode;
        node.nextNode = nextNode;
        size++;
    }

    public E remove() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<E> nextNode = head.nextNode;
        E ret = head.data;//삭제될 노드가 가지고 있는 데이터

        if (nextNode != null) {//삭제될 노드의 다음 노드가 존재하면!!
            nextNode.prevNode = null;//삭제될 노드의 다음노드가 가리키는 링크 끊어줘야됨
        }

        head = nextNode;//삭제될 노드의 다음 노드를 head로 임명
        size--;
        if (size == 0) {//size가 0이라는것은 삭제되고나서 아무 노드도 없다는 상태
            tail = null;//따라서 tail변수도 null로 초기화 해줘야됨
        }

        return ret;//삭제될 노드가 가지고 있는 data값 반환
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {//범위를 벗어난 index에 대해 예외 날림
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {//index가 0이면 결국 맨앞 노드삭제하는 것과 동일하므로 remove()호출
            return remove();
        }
        Node<E> removeNode = search(index);
        E ret = removeNode.data;
        Node<E> prevNode = removeNode.prevNode;//삭제될 노드의 앞 노드
        Node<E> nextNode = removeNode.nextNode;//삭제될 노드의 뒷 노드
        if(prevNode!=null){
            prevNode.nextNode=nextNode;
        }
        if(nextNode!=null){
            nextNode.prevNode=prevNode;
        }
        size--;
        if(size==0){
            head=tail=null;
        }
        return ret;
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E value) {

    }

    @Override
    public boolean contains(E value) {
        return false;
    }

    @Override
    public int indexOf(E value) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

        for(Node<E> x=head;x.nextNode!=null;){
            x.prevNode=null;
            x.data=null;
            Node<E> nextNode = x.nextNode;
            x.nextNode=null;
            x=nextNode;
        }
        size=0;
        head=tail=null;
    }
}
