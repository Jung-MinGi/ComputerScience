<h2>[[자료구조]]Queue</h2>
배열을 이용하여 Queue구현하기

전체코드보기
https://github.com/Jung-MinGi/dataStructure/blob/38ee82b64d6fe1cf56fb5707cf95b674cce7af30/src/main/java/com/java/dataStructureStudy/collection/queue/ArrayQueue.java#L5

<h3>🧐클래스 생성</h3>

```
public class ArrayQueue<E> implements Queue<E>{
    private static final int DEFAULT_CAPACITY=64;//배열의 최소크기
    private Object[] array;
    private int size;//배열안 요소의 개수
    private int front=0;
    private int rear=0;

    public ArrayQueue() {
        this.array=new Object[DEFAULT_CAPACITY];
        this.size=0;
        this.front=0;
        this.rear=0;
    }
}
```
front-- 큐에서 pop할때 나올 요소의 인덱스를 알기위해 사용돼는 변수

rear-- 큐에 offer할때 들어갈 위치를 알려주는 변수

<h3>🧐동적할당을 위해 resize()메서드 생성</h3>

```
private void resize(int newCapa){
    int currentLen = array.length;//현재 큐의 크기

    Object[] newArray = new Object[newCapa];
    int idx=front+1;
    for(int i=1;i<=size;i++){
        newArray[i]=array[idx%currentLen];
        idx++;
    }
    array = newArray;
    front=0;
    rear=size;
}
```
idx: 기존 배열에서 가장 앞에 위치한 요소부터 차례대로 넣기 위해 변수생성

idx%currentLen: 나머지 값을 이용해 배열 인덱스 찾기 위해

<h3>🧐offer()메서드 구현</h3>

```
    @Override
    public boolean offer(E value) {
        if ((rear + 1) % array.length == front) {
            resize(array.length * 2);
        }
//        rear++;
        rear = (rear+1)%array.length;
        array[rear] = value;
        size++;
        
        return true;
    }
```
? (rear+1)%array.length==front

큐가 꽉 찬 상태를 의미한다.

![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/e37f65e3-51fd-4086-8856-f9d88d656345)


출처 https://st-lab.tistory.com/183

? 큐에 새로운 값을 추가한 후 rear++하지 않고 (rear+1)%array.length하는 이유 

기본적으로 배열을 원형으로 이어진 상태로 봐야되기 때문에 위 사진에서 보면 7번 인덱스

에서 다음은 0을 가리켜야 되기 때문에 

<h3>🧐poll()메서드 구현</h3>

```
@Override
public E poll() {

    if (size == 0) return null;//배열안에 요소가 없는 경우

    front = (front + 1) % array.length;
    E ret = (E) array[front ];
    array[front] = null;
    size--;
    /**
     * 배열의 요소를 제거했으므로 공간낭비가 생기지 않게 배열의 크기를 재조정
     * 배열안의 요소개수가 전체크기의 1/4미만인경우 크기를 줄인다
     */
    if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
        //크기를 아무리 줄여도 최소크기값보다 작게 줄이지 않게 Math.max()를 해준다
        resize(Math.max(DEFAULT_CAPACITY, array.length / 4));
    }
    return ret;
}
```
<h3>🧐peek()메서드 구현</h3>

```
@Override
public E peek() {
    if (size == 0) {
        throw null;
    }
    front = (front + 1) % array.length;
    return (E) array[front];
}
```
poll()메서드에서 요소를 제거하는 코드만 제외하면 됨

<h3>🧐contains()&clear()메서드 구현</h3>

```
public boolean contains(Object value ){
    for(int i=front+1;i<=rear;i=(i+1)array.length){
        if(array[i].equals(value))return true;
    }
    return false;
}
public void clear(){
    for(int i=front+1;i<=rear;i++){
        array[i%array.length]=null;
    }
    size=0;
    front=0;
    rear=0;
}
```


출처 https://st-lab.tistory.com/183
