<h2>KMP알고리즘</h2>
문자열 매칭 문제에서 브루트포스로 탐색을 하게 되면<br>
시간복잡도가 O(N(주어진 문자열의 길이)*M(찾아야할 부분문자열))인데 반해<br>
이를 시간 복잡도 O(N+M)으로 줄일 수 있는 알고리즘이다.

```
    ↓
abababcd
ababc(부분 문자열)
    ↑
화살표가 가리키는 부분에서 서로 다를 경우  브루트포스에선 부분문자열을 한칸 밀어서 비교를 하게 되는데 여기서 시간복잡도가 커지게 됨.

4번인덱스에서 서로 다르다는 것은 다시 말하면 4번인덱스 이전까진 모두 값이 동일하다는 거임.

    
abababcd
  ababc(부분 문자열)
이렇게 바로 중간 단계를 건너뛰어 비교를 가능하게 하는 알고리즘이다.
```

우선 주어진 부분문자열에서 접두사와 접미사가 일치하는 부분을 찾아야 한다.

각각의 인덱스에서 일치하는 문자열의 최대길이를 찾아야함
```
부분 문자열 ababc이 주어 졌을떄
1.인덱스가 0일때
접두사 - 없음
접미사 - 없음

2.인덱스가 1일떄
접두사 - a
접미사 - b
일치하는 문자열이 없다

2.인덱스가 2일떄
접두사 - a, ab
접미사 - a, ba
일치하는 문자열 중 가장 길이가 큰 문자열을 2번인덱스에 저장

2.인덱스가 3일떄
접두사 - a, ab, aba
접미사 - a, ab, bab
일치하는 문자열 중 가장 길이가 큰 문자열을 3번인덱스에 저장

2.인덱스가 4일떄
접두사 - a, ab, aba, abab
접미사 - c, bc, abc, babc
일치하는 문자열이 없다


이렇게 해서 나온 배열 [0, 0, 1, 2, 0]을 이용해 문자열과 비교하면서 중간에 건너뛸 수 있다.
[위 과정을 코드로 구현]
   static void getPattern(){
        int maxLength=0;
        for(int i=1;i<pattern.length();i++){
            while(maxLength>0&&pattern.charAt(i)!=pattern.charAt(maxLength)){
                maxLength=pi[maxLength-1];
            }
            if(pattern.charAt(i)==pattern.charAt(maxLength)){
                pi[i]=++maxLength;
            }
        }
    }
```
```
    static void kmpAlgorithm(){
        int j=0;
        for(int i=0;i<all.length();i++){
            while(j>0&&all.charAt(i)!=pattern.charAt(j)){//현재 i인덱스 위치에서 일치하지 않으므로
                j=pi[j-1];
            
            }
            if(all.charAt(i)==pattern.charAt(j)){
                if(j==pattern.length()-1){
                    answer=1;
                    break;
                }else j++;
            }
        }
    }

/*
while(j>0&&all.charAt(i)!=pattern.charAt(j)){
                j=pi[j-1];
            
            }
현재i인덱스의 문자와 j인덱스의 문자가 서로 다를때 실행되는데
예를 들어 부분문자열의 패턴배열이 pi={0,0,1,2,0}일때
    ↓
abababcd
ababc(부분 문자열)
    ↑
4번 인덱스에서 서로 다르니
 j=pi[j-1];를 거쳐 j가 2가 됨
다시 while  조건부로 올라가 비교 
all.charAt(4)!=pattern.charAt(2)가 false가 되므로 while문을 탈출하게 됨
*/

```
