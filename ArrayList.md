<h3>[[자료구조]]ArrayList</h3>
자바의 가장 기본적인 리스트계열의 자료구조



<h3>🧐클래스 선언및 생성자 및 멤버변수 선언</h3>

```
public class ArrayList  {
    private static final int DEFAULT_CAPACITY = 10;//최소 용적
    private static final Object[] EMPTY_ARRAY = {};

    private int size;//arrayList안의 요소개수를 의미
    Object[] array;

    public ArrayList() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }
}
```

<h3>🧐resize()메서드 구현</h3>

ArrayList는 Object[]을 사용하기 때문에 동적할당이 가능하게 하기 위해 resize()메서드가 필요하다
```
    private void resize() {
        if (Arrays.equals(array, EMPTY_ARRAY)) {//array 크기가 0인 상태이면 
            array = new Object[DEFAULT_CAPACITY];//최소용적크기를 가지는 배열로 생성해준다.
            return;
        }

        int length = array.length;

        if (size == length) {//배열이 꽉 찬 상태이면 array의 크기를 두 배 크게해준다.
            array = Arrays.copyOf(array, length * 2);
            return;
        }
        if(size2){//배열안의 요소가 배열크기의 절반보다 작을때
            array = Arrays.copyOf(array,Math.max(DEFAULT_CAPACITY,length/2));
        }
    }
}
```
Math.max(DEFAULT_CAPACITY,length/2))의 의미
> 배열의 크기를 줄여도 최소용적크기보다 작으면 안되므로 두 값을 비교해 큰 값을 배열의 크기로 정한다.

<h3>🧐add()&addLast()구현</h3>

```
@Override
public boolean add(E value) {
    return true;
}

public void addLast(E value) {
    if(array.length==size){//배열크기와 요소의 개수가 일치하면 추가할 공간이 없는상태이므로
        resize();//배열의 크기를 늘려준다.
    }
    array[size]=value;
    size++;
}
```
<h3>🧐add(int index,E value)중간삽입 메서드 구현</h3>

```
@Override
public void add(int index, E value) {
    if (index < 0 || index >= size) {//index위치가 범위를 벗어나는 경우 예외를 던진다
        throw new IndexOutOfBoundsException();
    }

    if (index == size) {//삽입할 위치가 맨 뒤인경우 addLast()호출
        addLast(value);
        return;
    }

    if (size == array.length){//배열크기와 요소개수가 동일한 상태면 중간삽입이 불가능하니깐 크기 재조정해줘야한다
        resize();
    }

    for (int i = size - 1; i >= index; i--) {//뒤에서부터 삽입할 위치까지 모든 값을 한칸 뒤로 옮김;
        array[i + 1] = array[i];
    }
    array[index] = value;
    size++;
}
```
<h3>🧐addFirst(E value)메서드 구현</h3>

```
public void addFirst(E value){
    add(0,value);
}
```
제일 앞쪽에 삽입은 결국 add(int intdex,E value)를 호출해주면 된다.

<h3>🧐get(int index)메서드 구현</h3>

```
@Override
public E get(int index) {
    if (index < 0 || index >=size) {//index위치가 범위를 벗어나는 경우 예외를 던진다
        throw new IndexOutOfBoundsException();
    }

    return (E)array[index];
}
```
<h3>🧐set(int index,E value)메서드 구현</h3>
  
```
@Override
public void set(int index, E value) {
    if (index < 0 || index >= array.length) {//index위치가 범위를 벗어나는 경우 예외를 던진다
        throw new IndexOutOfBoundsException();
    }
    array[index]=value;
}
```
<h3>🧐indexOf(Object value)메서드 구현</h3>

```
@Override
public int indexOf(Object value) {
    for(int i=0;i<size;i++){
        if(value.equals(array[i]))return i;
    }
    return -1;
}
```
객체끼리 비교하므로 .equals()를 사용해준다

==연산자는 서로의 주소값을 비교한다.

<h3>🧐lastIndexOf(Object value)메서드 구현</h3>

```
public int lastIndexOf(Object value) {
    for(int i=size-1;i>=0;i--){
        if(value.equals(array[i]))return i;
    }
    return -1;
}
```
<h3>🧐contains(Object value)메서드 구현</h3>
  
```
@Override
public boolean contains(E value) {
    return indexOf(value)>=0;
}
```

indexOf메서드를 재활용해서 음수가 나오면 파라미터값이 arrayList안에 존재하지 않는다.



<h3>🧐remove(int index)메서드 구현</h3>

```
@Override
public E remove(int index) {
    if (index < 0 || index >= size) {//index위치가 범위를 벗어나는 경우 예외를 던진다
        throw new IndexOutOfBoundsException();
    }
    E ret = (E) array[index];
    array[index] = null;
    for (int i = index; i <size; i++) {
        array[i]=array[i+1];
        array[i+1]=null;
    }
    size--;
    return ret;
}
```
ret -- 삭제한 값을 리턴하기위한 임시변수

반복문을 돌리면 삭제한 위치의 index부터 끝까지 하나씩 앞으로 값을 땡기면 된다.

<h3>🧐remove(Object value)메서드 구현</h3>

```
@Override
public boolean remove(Object value) {
    int i = indexOf(value);
    if (i >= 0) {
        remove(i);
        return true;
    }
    return false;
}
```
indexOf메서드를 활용해 index값을 찾은후 remove메서드를 호출해주면 된다

만약찾으려는 인덱스가 존재하지않는 경우 -1을 반환하므로 그대로 false를 리턴해준다.

<h3>🧐size(),empty(),clear() 구현</h3>

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
    for(int i=0;i<size;i++)array[i]=null;
    size=0;
    resize();
}
```



출처 https://st-lab.tistory.com/161
