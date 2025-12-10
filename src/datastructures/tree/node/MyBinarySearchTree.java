package datastructures.tree.node;

import datastructures.tree.MyBinaryTree;

import java.util.Comparator;

/**
 * 목표: Linked 스타일로 노드를 연결하고, "작은 건 왼쪽, 큰 건 오른쪽" 규칙을 구현합니다.
 */
public class MyBinarySearchTree<E> implements MyBinaryTree<E> {

    // [Node 클래스] 주소 연결 방식
    private static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node<E> root;
    private int size;
    private final Comparator<? super E> comparator; // 정렬 기준 (없으면 Comparable)

    public MyBinarySearchTree() {
        this.comparator = null;
    }

    public MyBinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean add(E e) {
        // TODO: BST 규칙(작왼큰오)에 맞춰 노드 추가 구현
        // 힌트: 재귀나 반복문으로 위치 찾아서 new Node(e) 연결
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // TODO: 삭제 로직 (가장 어려움)
        // 1. 자식 0개: 그냥 삭제
        // 2. 자식 1개: 내 자식을 우리 부모님께 입양
        // 3. 자식 2개: 오른쪽 서브트리에서 제일 작은 놈(Successor) 데려오기
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // TODO: 루트부터 작으면 왼쪽, 크면 오른쪽으로 가며 찾기
        return false;
    }

    @Override
    public void preOrder() {
        // TODO: 전위 순회 구현 (보통 재귀 사용)
    }

    @Override
    public void inOrder() {
        // TODO: 중위 순회 구현 (결과가 정렬된 상태로 나옴)
    }

    @Override
    public void postOrder() {
        // TODO: 후위 순회 구현
    }

    @Override
    public void levelOrder() {
        // TODO: 큐(Queue)를 이용해서 구현
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        // TODO: 모든 노드 연결 끊기
    }
}