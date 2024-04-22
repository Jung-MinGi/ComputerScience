<h2>[[자료구조]]stack(스택)</h2>
가장 늦게 들어온 데이터가 가장 먼저 빠지는 후입선출의 자료구조

Object[]을 기반으로 구현된다.

<h3>🧐resize()메서드 구현</h3>

동적할당기능이 없으면 자료구조가 의미가 없다. 그냥 배열선언하는것과 똑같다
```
private void resize() {
    if (Arrays.equals(array, EMPTY_ARRAY)) {//스택안에 요소가 없을때
        array = new Object[DEFAULT_CAPACITY];//최소용적크기로 세팅
        return;
    }
    int length = array.length;
    if (length == size) {//스택안에 빈공간이 없을때
        int newSize = length * 2;//현재크기의 두배로 늘린다.
        array = Arrays.copyOf(array, newSize);
        return;
    }
    if (length / 2 > size) {//현재 크기의 절반보다 요소의 개수가 적을때
        int newSize = length / 2;//스택 사이즈를 절반으로 줄인다.
        array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY,newSize));
    }
}
```
<h3>🧐push()메서드 구현</h3>

```
@Override
public E push(E value) {
    if(size== array.length){//스택안에 데이터가 꽉 찬 상태이면 크기조정해야함
        resize();
    }
    array[size]=value;//제일 상단에 값을 넣어야하니깐 
    size++;
    return value;
}
```
<h3>🧐pop()메서드 구현</h3>

```
@Override
public E pop() {
    if (size == 0) {//pop할 요소가 없으면 예외를 던진다.
        throw new EmptyStackException();
    }
    E ret = (E) array[size - 1];
    array[size - 1] = null;
    size--;
    
    resize();//요소 제거후 크기 재조정
    return ret;//pop요소 반환
}
```
<h3>🧐peek()메서드 구현</h3>

pop메서드와 달리 가장 위에 있는 데이터를 뽑지않고 확인만 하고 싶을 경우
```
@Override
public E peek() {
    if (size == 0) {//peek할 요소가 없으면 예외를 던진다.
        throw new EmptyStackException();
    }

    return (E) array[size - 1];//peek요소 반환
}
```
pop메서드와 매우 유사하다.

<h3>🧐search(Object value)메서드 구현</h3>

list자료구조 같은 경우 탐색시 인덱스0번 부터또는 head노드부터 탐색을 시작하는데 스택의 경우 최상단의 데이터로부터 떨어진 거리를 반환해주는 메서드이다
```
@Override
public int search(Object value) {
    if(value==null){
        for(int i=size-1;i>=0;i--){
            if(array[i]==null){
                return size-i;
            }
        }
    }else{
        for(int i=size-1;i>=0;i--){
            if(array[i].equals(value)){
                return size-i;
            }
        }
    }
    return -1;//찾고자 하는 value값이 스택에 없는경우
}
```
파라이터가 null인경우 equals메서드를 사용하면 예외가 발생하니 조건을 분기한다.

반환값이 size-i인 이유는 최상단에서 떨어진 거리를 반환해줘야 하므로 원하는 값이 스택에 없는 경우는 -1을 반환한다.

<h3>🧐size()메서드 구현</h3>

```
@Override
public int size() {
    return size;
}
```
<h3>🧐clear()메서드 구현</h3>

```
@Override
public void clear() {
    for(int i=0;i<size;i++){
        array[i]=null;
    }
    size=0;
    resize();
}
```
<h3>🧐empty()메서드 구현</h3>

```
@Override
public boolean empty() {
    return size==0;
}
```

출처 https://st-lab.tistory.com/174
