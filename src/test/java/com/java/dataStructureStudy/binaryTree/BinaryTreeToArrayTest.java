package com.java.dataStructureStudy.binaryTree;

import com.java.dataStructureStudy.tree.Node;
import com.java.dataStructureStudy.tree.Tree;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

/**
 *       A
 *     /  \
 *    B    C
 *  /    /  \
 * D    E    F
 *            \
 *            G
 * 위와 같은 트리가 입력으로 주어짐
 */
class BinaryTreeToArrayTest {
    Tree tree = new Tree();

    @BeforeEach
    void setUp(){
      String[] arr={ "A B C", "B D .", "C E F", "E . .", "F . G", "D . .", "G . ."};//노드 정보
      for (String s : arr) {
          StringTokenizer st = new StringTokenizer(s);
          char a = st.nextToken().charAt(0);
          Node parentNode = tree.search(tree.getRoot(), a);
          if(parentNode==null){
              parentNode = tree.makeNode(a,null,null);
              tree.setRoot(parentNode);
          }
          char b = st.nextToken().charAt(0);
          if(b!='.') {
              parentNode.setLeft( tree.makeNode(b,null,null));
          }
          char c = st.nextToken().charAt(0);
          if(c!='.'){
              parentNode.setRight(tree.makeNode(c,null,null));
          }
      }
    }
    @Test
    @DisplayName("search메서드")
    public void test1(){
        Node ret = tree.search(tree.getRoot(), 'G');
        Assertions.assertThat(ret.getData()).isEqualTo('G');
    }
    @Test
    @DisplayName("searchAllTree메서드")
    public void test2(){
        tree.searchAllTree(tree.getRoot());
//        Assertions.assertThat(ret.getData()).isEqualTo('G');
    }
    @Test
    @DisplayName("전위,중위,후위 메서드")
    void test3(){
        System.out.print("전위순회: ");
        tree.preOrder(tree.getRoot());
        System.out.println();
        System.out.print("중위순회: ");
        tree.inOrder(tree.getRoot());
        System.out.println();
        System.out.print("후위순회: ");
        tree.postOrder(tree.getRoot());
    }

}