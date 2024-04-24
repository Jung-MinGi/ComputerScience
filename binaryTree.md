<h3>이진트리(binary tree)</h3>
데이터를 선형적으로 저장하는 자료구조와 달리 계층형으로 데이터를 저장할 수 있는 방법이다.

🧐 이진트리(binary tree)

하나의 루트를 가지며 모든 노드의 자식수가 2개이하인 트리를 말한다.

![image](https://github.com/Jung-MinGi/dataStructure/assets/118701129/dfebc117-0067-467d-9fd6-5f940cec2410)


출처 https://miro.medium.com/v2/resize:fit:640/format:webp/1*Etc4C2_vkbIgBUApJKMJag.png

[[배열 기반 이진 트리 구현]]

노드 생성
```
public class Node {
     char data;
     Node left;
     Node right;
}
```

배열로 구현할 경우 배열의 사이즈 는 2^노드개수+1

연결리스트를 활용한 이진트리
```
public class Tree {


    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node search(Node parent, char value) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(parent);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll == null) continue;
            if (poll.data == value) return poll;
            else {
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return null;
    }

    public void searchAllTree(Node parent) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(parent);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll == null) continue;
            System.out.println("현재 노드:" + poll.getData() + " leftNode: " + (poll.left!=null?poll.left.data:"null") + " rightNode: " +(poll.right!=null?poll.right.data:"null"));
            queue.add(poll.left);
            queue.add(poll.right);
        }
    }

    public Node makeNode(char data, Node left, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }
}
```
search()는 bfs를 이용했다.

