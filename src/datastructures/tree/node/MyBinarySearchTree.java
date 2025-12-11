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

    // [도우미 함수] Comparator가 있으면 그거 쓰고, 없으면 Comparable(형변환) 사용
    private int compare(E a, E b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            // comparator가 없으면 E는 무조건 Comparable이어야 함 (안 그러면 여기서 에러 발생)
            if (a == null) {
                throw new NullPointerException("요소는 null일 수 없습니다.");
            }
            if (!(a instanceof Comparable)) {
                throw new ClassCastException(a.getClass().getName() + " 클래스는 Comparable을 구현하지 않았습니다.");
            }
            @SuppressWarnings("unchecked")
            Comparable<? super E> comp = (Comparable<? super E>) a;
            return comp.compareTo(b);
        }
    }

    @Override
    public boolean add(E e) {
        // 1. 트리가 비어있을 때 (첫 노드)
        if (root == null) {
            root = new Node<>(e);
            size++;
            return true;
        }

        // 2. 탐색 및 삽입 (반복문 사용)
        Node<E> current = root;
        Node<E> parent;
        int compResult;

        while (true) {
            parent = current;
            // 아까 만든 도우미 함수로 값 비교
            compResult = compare(e, current.value);

            // [중복] 값이 같으면 넣지 않고 false 반환
            if (compResult == 0) {
                return false;
            }

            // [왼쪽] 입력값이 더 작음 -> 왼쪽으로 이동
            else if (compResult < 0) {
                current = current.left;
                // 왼쪽 자리가 비어있으면 거기 차지!
                if (current == null) {
                    parent.left = new Node<>(e);
                    size++;
                    return true;
                }
            }

            // [오른쪽] 입력값이 더 큼 -> 오른쪽으로 이동
            else {
                current = current.right;
                // 오른쪽 자리가 비어있으면 거기 차지!
                if (current == null) {
                    parent.right = new Node<>(e);
                    size++;
                    return true;
                }
            }
        }
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