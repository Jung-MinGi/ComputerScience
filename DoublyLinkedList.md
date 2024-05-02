<h2>[[자료구조]]Doubly LinkedList (이중 연결리스트)</h2>

전체코드보기
> https://github.com/Jung-MinGi/dataStructure/blob/14ed2ba9096b2c4307683e6b23552a61c86966a6/src/main/java/com/java/dataStructureStudy/collection/DoublyLinkedList.java#L6
> 
단일연결리스트와의 차이점

![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/144fce86-e3bd-4895-95b2-1b5eb541c4b0)


출처 https://st-lab.tistory.com/169

이전노드를 가리키는 레퍼런스변수가 하나 더 존재한다.

단일연결리스트에 비해 검색능력이 좋아진다. 찾으려는 노드가 tail쪽과 가깝다면 tail노드부터 탐색을하면 효율적이다.

<h3>🧐노드 생성</h3>

```
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
```
<h3>🧐search 메소드 구현</h3>

```
private Node<E> search(int index) {
    //찾으려는 index가 범위를 벗어난 경우
    if (index < 0 || index >= size) throw new NoSuchElementException();
    Node<E> x = null;
    if (index < size / 2) {//head부터 탐색
        x = head;
        for (int i = 0; i < index; i++) {
            x = x.nextNode;
        }
        return x.nextNode;
    } else {//tail부터 탐색
        x=tail;
        for(int i=size-1;i>index;i--){
            x=x.prevNode;
        }
        return x.prevNode;
    }
}
```
찾으려는 index를 기준으로 size의 mid값을 기준으로 왼쪽에 있으면 head노드부터 탐색 시작 mid값을 기준으로 오른쪽에 있으면 tail노드부터 탐색시작한다.

<h3>🧐add메서드구현</h3>

1. addFirst()
```

public void addFirst(E value){
    Node<E> node = new Node<>(value);

    node.nextNode=head;//새로만든 노드의 nextNode에 head를 연결
    
    if(head!=null){//nullpoint방지
        head.prevNode=node;//기존의head의 prevNode에 새로 추가될 노드 연결
    }
    head=node;//head노드를 새로운노드로 바꿔줌
    size++;
    //head의 다음 노드가 없는경우 사이즈가 1이므로
    //head와tail이 동일한 노드를 가리키게 만들어야됨
    if(head.nextNode==null){
        tail=head;
    }
}
```
2.add(),addLast()구현

```
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
```
size==0인경우 addFirst를 호출해서 사용해도 별 문제 없다.

3. add(int index,E value) 중간에 요소 삽입

```
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
    targetNode.nextNode=node;
    nextNode.prevNode=node;
    node.prevNode=targetNode;
    node.nextNode=nextNode;
    size++;
}
```
삽입하려는 위치가 맨 앞 or 맨 뒤인경우 기존에 만들어둔 메서드 이용하면 됨

중간에 삽입할땐 search()로 삽입하려는  위치에 있는 현재 노드를 가져와서 가져온 노드와 다음 노드사이에 새로운 노드를 서로 링크 시켜주면 됨

<h3>🧐remove메서드 구현</h3>

1. remove()

가장 앞에있는 요소 삭제

```
public E remove() {
    if (head == null) {
        throw new NoSuchElementException();
    }
    Node<E> nextNode = head.nextNode;
    E removeValue = head.data;//삭제될 노드가 가지고 있는 데이터
    
    if (nextNode != null) {//삭제될 노드의 다음 노드가 존재하면!!
        nextNode.prevNode = null;//삭제될 노드의 다음노드가 가리키는 링크 끊어줘야됨
    }

    head = nextNode;//삭제될 노드의 다음 노드를 head로 임명
    size--;
    if (size == 0) {//size가 0이라는것은 삭제되고나서 아무 노드도 없다는 상태
        tail = null;//따라서 tail변수도 null로 초기화 해줘야됨
    }
    
    return removeValue;//삭제될 노드가 가지고 있는 data값 반환
}
```
2.remove(int index)메서드

사용자가 원하는 특정index에 위치한 노드 삭제

```
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
```
3. remove(E value)메서드 구현

특정 값을 지닌 노드 삭제하는 메서드

```
@Override
public boolean remove(E value) {

    Node<E> x = head;
    for (x = head; x != null; x = x.nextNode) {//노드 탐색
        if (x.data.equals(value)) break;
    }

    if (x == null) return false;//일치하는 값을 가지는 노드가 없는경우

    if(x.equals(head)){//삭제할 노드가 head노드인 경우
        remove();
        return true;
    }

    Node<E> prevNode = x.prevNode;
    Node<E> nextNode = x.nextNode;
    if(nextNode!=null){//삭제할 노드의 다음노드가 null이 아닌경우
        prevNode.nextNode=nextNode;//삭제노드 앞노드와 삭제노드 다음노드와 서로 링크 시켜줌
        nextNode.prevNode=prevNode;
    }else prevNode=tail;//삭제 노드 다음 노드가 null인경우 삭제할 노드가 tail이라는 의미이므로
                        //삭제할 노드 앞 노드를 tail로 지정
    size--;
    return true;
}
```
<h3>🧐get()구현</h3>

```
@Override
public E get(int index) {
    return search(index).data;
}
🧐search()구현

@Override
public void set(int index, E value) {
    search(index).data=value;
}
🧐contains()&indexOf()구현

@Override
public boolean contains(E value) {
    return indexOf(value)>=0;
}

@Override
public int indexOf(E value) {
    Node<E> x = head;
    int index=0;
    for(;x!=null;x=x.nextNode){
        if(x.data.equals(value)){
            return index;
        }
        index++;
    }
    return -1;
}
```
<h3>🧐size()&isEmpty()&clear()구현</h3>

```
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

    for (Node<E> x = head; x.nextNode != null; ) {
        x.prevNode = null;
        x.data = null;
        Node<E> nextNode = x.nextNode;
        x.nextNode = null;
        x = nextNode;
    }
    size = 0;
    head = tail = null;
}
```

출처 https://st-lab.tistory.com/169

