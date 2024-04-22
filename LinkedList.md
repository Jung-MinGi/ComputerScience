<h2>[[자료구조]] 단일 연결 리스트(singly LinkedList)</h2>

전체코드보기
> https://github.com/Jung-MinGi/dataStructure/blob/fba7c8f7101a2cd01ddfb592287943be46eec195/src/main/java/com/java/dataStructureStudy/collection/LinkedList.java#L5

단일연결 리스트를 이루는 노드 모양

![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/bdb48b0b-9ecf-416c-b2ac-779bb82162fa)

출처 https://st-lab.tistory.com/167



data -- 사용자가 저장하는 데이터

reference--다음 노드의 위치를 알려주는 값

![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/abe692de-10b7-4c21-bfc4-b6b7f89ea64b)




출처 https://st-lab.tistory.com/167

리스트의 첫번째 노드를 head 마지막 노드를 tail이라고 부른다.

배열과 달리 다뤄야할 데이터 집합의 크기를 모를때 매우 유용하다.

<<ArrayList vs LinkedList>>

중간삽입,제거에 있어서는 LinkedList가 훨씬 빠르고

인덱스를 이용한 접근은 ArrayList가 더 빠르다

<<구현>>

1. 노드 생성
```
public class Node<E>{
    E data;//저장할 데이터
    Node<E> nextNode;//다음 노드를 가리킨다

    public Node(E data, Node<E> nextNode) {
        this.data = data;
        this.nextNode = null;
    }
}
```
2.클래스 만들기
```
public class LinkedList<E> implements List{
    private Node<E> head;//리스트의 가장 앞노드
    private Node<E> tail;//리스트의 마지막 노드
    private int size;//노드의 개수

    public LinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }
}
```
초기값은 null,0으로 초기화해준다.

<h3>🧐search메서드 구현</h3>

```
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
```
반복문에서 i<=index로 두면 안됨 그럼 반환노드가 index노드의 다음노드가 반환됨

<h3>🧐add메서드구현</h3>

1.addFirst(가장 앞부분에 노드 추가)
```
public void addFirst(E data){
    Node<E> node = new Node<>(data);
    node.nextNode=head;//기존에 맨앞에 존재하는 노드를 추가하려는 노드의 nextNode에 매칭해줌
    head=node;//head노드를 새로 추가하려는 노드로 바꿈
    size++;//요소개수++

    if(size==1){
        tail=head;
    }
}
```
🤔if(size==1)

size가 1이라는 것은 현재 추가하려는 노드밖에 존재하지 않는다는 의미이므로 head와tail이 가리키는 노드가 동일하다는 의미이다.

2.add()&addLast()

add()를 호출하게 되면 결국 addLast()를 호출하는것과 동일
```
@Override
public boolean add(E value) {
    addLast(value);
    return true;
}
public void addLast(E data) {
    Node<E> node = new Node<>(data);
    if(size==0){//size가 0이면 addFirst()메서드 호출
        addFirst(data);
    }
    tail.nextNode=node;
    size++;
}
3.add(int index,E value) 중간삽입

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
    Node<E> prev_Node = search(index-1);//index-1에 위치한 노드
    Node<E> currentNode = prev_Node.nextNode;//index에 위치한 노드

    //위 둘 사이에 넣어주면 됨
    Node<E> node = new Node<>(value);
    prev_Node.nextNode=node;
    node.nextNode=currentNode;
    size++;
}
```
특정위치에 노드를 삽입하려면 한 칸 앞에 있는노드와  특정위치에 있는 노드를 둘 다 찾아내서 그사이에 링크를 끊고 새로운 노드를 삽입해주면 됨

<h3>🧐remove메서드 구현</h3>

1.가장 앞에 있는 노드 삭제메서드
```
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
    if(size==0){
        tail=null;
    }
    return ret;
}
```
2.특정 index에 위치한 노드삭제 메서드
```
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
```

3. 특정 data를 가지고 있는 노드 삭제 메서드

```
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
    if(prev_Node.nextNode==null){
        tail=prev_Node;
    }
    size--;
    return true;
}
```
<h3>🧐get메서드 구현</h3>

```
@Override
public E get(int index) {
    return search(index).data;
}
```
<h3>🧐set메서드 구현</h3>

```
@Override
public void set(int index, E value) {
    Node<E> node = search(index);
    node.data=value;
}
```
<h3>🧐indexOf메서드 구현</h3>

```
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
```
<h3>🧐contains메서드 구현</h3>

```
@Override
public boolean contains(E value) {
    return indexOf(value)>=0;
}
```

출처 https://st-lab.tistory.com/167
