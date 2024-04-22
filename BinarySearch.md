<h2>[[알고리즘]] 이분 탐색(binarySearch)</h2>
정렬에 리스트에서 주어진 조건을 만족하는  최댓값 또는 최솟값을 찾는 문제에 사용된다. O(N)선형 탐색으로 시간내에 해결되지 않을때  효과적이다.

```
static void binarySearch(int max,int target) {
    int low = 0;
    int high = max;
    while (low + 1 < high) {
        int mid = (low + high) / 2;
        if (mid > target) low = mid;//mid값을 기준으로 target의 위치를 판별한다
        else high = mid;
    }
}
```
🧐 while (low + 1 < high)로 설정하는 이유 

이분탐색은 정렬된 리스트에서 주어진 조건에 따라 모든 요소들이 true or false를 가지는 형태인데, 처음 check(low)!=check(high)가 되도록 구간 [low,high]을 잡아주면 된다.

그럼 while문을 탈출하고 나서는 아래와 같은 상황이된다.



그럼 check()를 만족하는 최대값을 원할 땐 lo를

check()를 만족하는 최소값을 원할 땐 hi가 답이된다.

참고
![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/5be17ac5-a311-44ba-a903-9822e8b34331)

https://www.acmicpc.net/blog/view/109
