package com.java.dataStructureStudy.tree;

public class Bst {
    Node<Integer> root;

    public void makeTree(int[] a) {
        root = makeTreeRecursive(a, 0, a.length - 1,null);
    }

    public Node<Integer> makeTreeRecursive(int[] a, int start, int end,Node<Integer> parent) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node<Integer> node = new Node<>();
        node.parent=parent;
        node.data = a[mid];
        node.left = makeTreeRecursive(a, start, mid - 1,node);
        node.right = makeTreeRecursive(a, mid + 1, end,node);
        return node;
    }

    public Node<Integer> search(Node<Integer> currentNode,int value){
        if(currentNode!=null){
            if(currentNode.data.equals(value))return currentNode;
            else if(currentNode.data < value) return search(currentNode.right,value);
            else  return search(currentNode.left,value);
        }
        return null;
    }
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
    /*
        삭제될 노드의 자리에 대신들어갈 노드 찾는 메서드
     */
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
    public void preOrder(Node<Integer> root,int level){
        if(root==null)return;
        preOrder(root.left,level+1);
        System.out.println("레벨: "+level+" 노드번호: "+root.data);
        preOrder(root.right,level+1);
    }

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

}
