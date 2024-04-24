[[알고리즘]]next_permutation
백준1821번 문제를 백트래킹으로 푸는데 재귀가 너무 깊은지 메모리초과가 계속 발생해서 다른 방법을 찾다가 "다음순열알고리즘"을 알게됨

백트래킹보다 시간복잡도가 낮다

```
static void next_permutation() {
    int i = arr.length - 2;
    while (i >= 0 && arr[i] >= arr[i + 1]) i--;
    int pivot = i;
    if (pivot < 0) return;
    int j = arr.length - 1;
    while (j > pivot && arr[pivot] >= arr[j]) {
        j--;
    }
    //swap
    swap(pivot, j);
    //
    pivot++;
    j = arr.length - 1;
    while (pivot < j) {
        swap(pivot, j);
        pivot++;
        j--;
    }
}

static void swap(int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}
```
아래는 파스칼 삼각형 형식으로 더해나가는 알고리즘

```
public static int soultion(int[] temp) {
    if(temp.length==2) {     
        return temp[0]+temp[1];
    }

    int[] next = new int[temp.length-1];
    int i = 0;
    int j = 1;

    while(j<temp.length) {
        next[i] = temp[i]+temp[j];
        i++;
        j++;
    }

    return soultion(next);
}
```
