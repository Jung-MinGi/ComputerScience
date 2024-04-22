[[자료구조]] Binary Search Tree 이진탐색 트리
효율적인 탐색을 위한 이진트리기반의 자료구조이다

데이터가 변하지 않고 정렬된 상태라면 이진탐색을 사용하겠지만, 데이터의 삽입, 삭제가 빈번한 상황에선 트리형태의 자료구조가 적합합니다.

이진 트리 중에서도 이진 탐색 트리는 데이터가 동적으로 변화는 상황에 유리한 트리이다.


![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/b3b23b15-e78a-4119-ba0f-0607f8ba6cd5)

출처 https://st-lab.tistory.com/300



이진 탐색 트리는 다음의 조건을 만족합니다

✓ 부모 노드 기준 왼쪽 노드는 부모노드의 값보다 작다

✓ 부모노드 기준 오른쪽 노드는 부모노드의 값보다 크다

✓ 하위 서브트리도 위에 조건들을 만족한다

```
/**
 * [이진트리 구현]
 *         4
 *      /    \
 *    1       7
 *   / \     / \
 *  0   2   5  8
 *       \   \  \
 *        3   6  9
 * @param args
 */
```
<h3>노드생성</h3>

```
public class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;
    Node<T> parent;
}
public class BinarySearchTree {
    public Node root;//트리의 시작 위치
   ...
}
```
<h3>트리생성 메서드 생성</h3>

```
public void makeTree(int[] a) {
    root = makeTreeRecursive(a, 0, a.length - 1,null);
}

public Node makeTreeRecursive(int[] a, int start, int end,Node parent) {
    if (start > end) return null;
    int mid = (start + end) / 2;
    Node node = new Node<>();
    node.parent=parent;
    node.data = a[mid];
    node.left = makeTreeRecursive(a, start, mid - 1,node);
    node.right = makeTreeRecursive(a, mid + 1, end,node);
    return node;
}
```
<h3>삭제 메서드 생성</h3>

노드가 삭제될 때 발생할 수 있는 상황

1.  삭제노드가 leafNode인 경우

2. 삭제노드가 자식노드를 하나만 가지고 있는 경우

3. 삭제노드가 왼쪽,오른쪽 모두 자식노드를 가지고 있는 경우

3번 상황에서 고려해야 할 점 왼쪽,오른쪽 트리를 모두 가지고 있는 경우 삭제되는 노드 자리에 누가 대체자로 올지 결정해줘야 한다.

![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/9264e952-d4e1-49a1-b825-da00a536e08f)

출처 https://st-lab.tistory.com/300



위 그림에서 12번 노드를 삭제하고 나서 그 자리를 대체할 노드 결정하는 기준



1. 삭제노드보다 작으면서 가장 큰 노드를 후계자



2.삭제노드보다 크면서 가장 작은 노드를 후계자

2번 방법으로 구현

<h3>후계자 찾는 메서드 생성</h3>

```
public Node<Integer> getSuccessor(Node<Integer> deleted){
    Node current=deleted.right;

    if(current==null){
        return current;
    }
    while(current.left!=null){
        current = current.left;
    }
    /*
        1.후계자노드가 오른쪽 노드를 가지고 있는 경우
        링크를 끊어주어야 한다.
     */
    if(current.right!=null){
        current.parent.right=current.right;
        current.right=null;
    }
    return current;
}
```
<h3>삭제 메서드 생성</h3>

```
public void remove(Node<Integer> root,int value){
    if(root==null)return;
    if(root.data < value)remove(root.right,value);
    else if(root.data > value)remove(root.left,value);
    else{//재귀 타고 오다가 삭제할 노드를 찾은경우
        /*
          1. 삭제할 노드가 리프노드인 경우
        */
        if(root.left==null&&root.right==null){
            Node<Integer> parent = root.parent;
            if(parent.left!=null&&parent.left.data.equals(value)){
                parent.left=null;
                root.data=null;
            }else{
                parent.right=null;
                root.data=null;
            }
            return;
        }
        /*
         2.삭제할 노드가 왼쪽서브트리 or 오른쪽 서브트리를 가지고 있는경우
         */
        else if(root.left!=null&&root.right==null){
         /*
           2-1 삭제할 노드가 왼쪽 서브트리를 가지고 있는 경우
          */
            Node<Integer> successor = root.left;
            root.data=successor.data;

        }else if(root.left == null){
          /*
           2-2 삭제할 노드가 오른쪽 서브트리를 가지고 있는 경우
          */
            Node<Integer> successor = root.right;
            root.data=successor.data;
        }else{
            /*
              3. 삭제할 노드가 왼쪽, 오른쪽 서브트리를 둘 다 가지고 있는 경우
                 이때  successor메서드이용해서 현재 노드보다 크면서 가장 작은 값을 구해준다
             */
            Node<Integer> successor = getSuccessor(root);
            root.data=successor.data;
        }
    }
}
```
참고 

https://st-lab.tistory.com/300

⌈문제해결전략⌋ 책 참조
