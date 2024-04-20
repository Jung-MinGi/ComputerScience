package com.java.dataStructureStudy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {


    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node<Character> root) {
        this.root = root;
    }

    public Node<Character> search(Node<Character> parent, char value) {
        Queue<Node<Character>> queue = new LinkedList<>();
        queue.add(parent);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll == null) continue;
//            System.out.println("현재 노드:" + parent.getData() + " leftNode: " + parent.left.data + " rightNode: " + parent.right.data);
            if (poll.data .equals(value)) return poll;
            else {
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return null;
    }

    public void searchAllTree(Node<Character> parent) {
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


