<h3>union-find 연산</h3>
Union-Find란 ﻿서로 중복되지 않는 부분 집합(disjoint set)을 표현할 때 사용하는 자료구조이다.

Union-Find에 쓰이는 연산

• 초기화: n개의 원소가 각각의 집합을 이루도록 초기화 한다.

• union연산:두 집합 a,b를 하나로 합친다.

• find연산:어떤 원소 a가 주어질때, 이 원소가 속합 집합을 반환한다.

※Union-Find를 배열로 표현했을 때 문제점

![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/7ee855b7-a12e-4faa-bb53-6c85d9442a84)


출처 https://bowbowbow.tistory.com/26

﻿>> 배열로 집합을 표현시  union연산에서 3번 집합에 속한 원소들을 2번 집합으로 바꾸기 위해 모든 원소를 순회해야한다. 이런 문제를 트리구조로 표현하면 시간복잡도가 줄어든다.

※ 배열대신 트리로 표현하기

﻿트리를 사용하면 union연산을 더 빨리 수행가능하다.
```
public int find(int x) {
    if (set[x] == x) return x;
    return find(set[x]);
}

public void union(int a, int b) {
    a = find(a);
    b = find(b);

    set[b] = a;
}
```
﻿find메서드와union메서드를 위 코드처럼 구현하게 되면 트리가 극단적으로 치우친 연결리스트 형태가 나타날 수 있는데

 ﻿﻿![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/2a791629-30b6-4381-a52a-df28ba9e778d)
                                                            ﻿

이런식이면 배열로 구현했을때 보다 효율이 떨어진다

배열에선 적어도 find연산이 상수시간이 걸리니깐

이런 문제는 두 트리를 합칠 때 높이가 더 낮은 트리를 더 높은 트리로 이어줌으로써 해결가능하다. (union-by-rank라고 부른다)

<<최적화 구현>>

• find연산
```
public int find(int x) {
    if (set[x] == x) return x;
    return set[x]=find(set[x]);
    /**
     *탐색 경로에 있는 모든
     * set[x]에 루트노드값을 다이렉트로 넣어줌.
     */
}
```
• union연산
```
public void union(int a, int b) {
    a = find(a);
    b = find(b);
    if(a==b)return;//같은 집합이면 합칠 필요 없음
    if(rank[a]>rank[b]){//트리의 높이를 기준으로 비교한다
        set[b]=a;
    }else {
        set[a]=b;
        if(rank[a]==rank[b])rank[a]++;//높이가 같은면 a의 rank를 +1
    }
}
```
참고

https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html

https://bowbowbow.tistory.com/26
