package com.java.dataStructureStudy.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BstTest {
    int[] a = new int[10];
    Bst binarySearchTree;

    @BeforeEach
    void init() {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        binarySearchTree = new Bst();
        binarySearchTree.makeTree(a);
    }

    @Test
    @DisplayName("search메서드")
    void test1() {
        for (int i = 0; i < 10; i++) {
            Assertions.assertThat(binarySearchTree.search(binarySearchTree.root, i).data).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("getSuccessor메서드")
    void test2() {
        Node<Integer> node = binarySearchTree.search(binarySearchTree.root, 7);
        Node successor = binarySearchTree.getSuccessor(node);
        if (successor != null) Assertions.assertThat(successor.data).isEqualTo(8);
    }

    @Test
    @DisplayName("특정노드의 부모노드 확인")
    void test3() {
        Integer[][] edge = {{1, 4}, {0, 1}, {2, 1}, {3, 2}, {7, 4}, {5, 7}, {6, 5}, {8, 7}, {9, 8}};
        for (Integer[] integers : edge) {
            Node<Integer> node = binarySearchTree.search(binarySearchTree.root, integers[0]);
            Assertions.assertThat(node.parent.data).isEqualTo(integers[1]);
        }
    }

    @Test
    @DisplayName("remove메서드 확인")
    void test4() {
        /*
              4
           /    \
         1       7
        / \     / \
       0   2   5  8
            \   \  \
             3   6  9
        7번 노드를 지우면 8번노드가 그자리에 있어야됨
     */
        binarySearchTree.remove(binarySearchTree.root,7);
        Assertions.assertThat(binarySearchTree.root.data).isEqualTo(4);
        Assertions.assertThat(binarySearchTree.search(binarySearchTree.root,8).parent).isEqualTo(binarySearchTree.root);

    }

}