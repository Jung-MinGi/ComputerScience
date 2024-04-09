package com.java.dataStructureStudy.collection;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
    private Node<E> head;//리스트의 가장 앞노드
    private Node<E> tail;//리스트의 마지막 노드
    private int size;//노드의 개수

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    /**
     * @param index 탐색노드의 인덱스 번호
     * @return 탐색한 노드 반환
     */
    private Node<E> search(int index) {

        //인덱스가 범위에 안맞는 경우 예외반환
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = head.nextNode;
        }
        return node;
    }

    public void addFirst(E data) {
        Node<E> node = new Node<>(data);
        node.nextNode = head;//기존에 맨앞에 존재하는 노드를 추가하려는 노드의 nextNode에 매칭해줌
        head = node;//head노드를 새로 추가하려는 노드로 바꿈
        size++;//요소개수++

        if (size == 1) {
            tail = head;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E data) {
        Node<E> node = new Node<>(data);
        if (size == 0) {//size가 0이면 addFirst()메서드 호출
            addFirst(data);
        }
        tail.nextNode = node;
        size++;
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
        
        Node<E> prev_Node = search(index - 1);//index-1에 위치한 노드
        Node<E> currentNode = prev_Node.nextNode;//index에 위치한 노드

        //위 둘 사이에 넣어주면 됨
        Node<E> node = new Node<>(value);
        prev_Node.nextNode = node;
        node.nextNode = currentNode;
        size++;
    }

    public E remove() {
        Node<E> headNode = head;
        if (headNode == null) throw new NoSuchElementException();
        //삭제될 노드가 가지고있는 데이터 임시 저장
        E ret = headNode.data;
        //삭제될 노드의 다음노드를 head로 지정해줌
        Node<E> nextNode = headNode.nextNode;
        head = nextNode;

        size--;
        //size가 0이면 삭제당한 노드가 마지막 요소였으면
        // head==tail이 같은 노드를 가리키고 있으므로 tail도 null처리해준다.
        if (size == 0) {
            tail = null;
        }
        return ret;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return remove();
        }
        //삭제할 노드 앞부분 노드
        Node<E> prev_Node = search(index - 1);

        Node<E> remove_Node = prev_Node.nextNode;
        //삭제할 노드 앞쪽 노드와 삭제할 노드 뒤쪽 노드 서로 링크
        prev_Node.nextNode = remove_Node.nextNode;

        if (prev_Node.nextNode == null) {
            tail = prev_Node;
        }
        size--;
        return remove_Node.data;
    }

    @Override
    public boolean remove(E value) {
        Node<E> prev_Node = head;
        boolean flag = false;
        Node<E> x = head;//삭제할 노드
        //리스트를 순회하면서 파라미터값과 일치하는 데이터를 가진 노드 탐색
        for (; x != null; x = x.nextNode) {
            if (x.data.equals(value)) {
                flag = true;
                break;
            }
            prev_Node = x;
        }

        if (!flag) return false;
        //삭제할 노드가 head에 위치한 경우 기존에 remove()호출
        if (x.equals(head)) {
            remove();
            return true;
        }

        prev_Node.nextNode = x.nextNode;
        if (prev_Node.nextNode == null) {
            tail = prev_Node;
        }
        size--;
        return true;
    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> node = search(index);
        node.data = value;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value)>=0;
    }

    @Override
    public int indexOf(E value) {
        int index = 0;

        for (Node<E> x = head; x != null; x = x.nextNode) {
            if (x.data.equals(value)) {
                return index;
            }
            index++;
        }
        return -1;//찾고자 하는 요소가 없을때 반환
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void clear() {

    }
}
