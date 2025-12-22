package datastructures.tree.node;

import datastructures.tree.MyBinaryTree;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree<E> implements MyBinaryTree<E> {

    // 노드 클래스: 데이터를 저장하고 좌우 자식 노드를 연결
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
    private final Comparator<? super E> comparator; // 사용자 정의 정렬 기준

    public MyBinarySearchTree() {
        this.comparator = null;
    }

    public MyBinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    // 비교 로직: Comparator가 있으면 사용하고, 없으면 Comparable로 형변환하여 수행
    // comparator가 있든 없든, 이 트리는 null을 데이터로 취급하지 않는다.
    @SuppressWarnings("unchecked")
    private int compare(E a, E b) {
        if (a == null || b == null) {
            throw new NullPointerException("요소는 null일 수 없습니다.");
        }

        if (comparator != null) {
            return comparator.compare(a, b);
        }

        if (!(a instanceof Comparable)) {
            throw new ClassCastException(a.getClass().getName() + " 클래스는 Comparable을 구현하지 않았습니다.");
        }
        return ((Comparable<? super E>) a).compareTo(b);
    }


    @Override
    public boolean add(E e) {
        // 1. 트리가 비어있는 경우 루트로 설정
        if (root == null) {
            root = new Node<>(e);
            size++;
            return true;
        }

        // 2. 탐색 및 삽입 위치 결정 (반복문 사용)
        Node<E> current = root;
        Node<E> parent;
        int compResult;

        while (true) {
            parent = current;
            compResult = compare(e, current.value);

            // 중복 값은 허용하지 않음
            if (compResult == 0) {
                return false;
            }
            // 입력값이 더 작으면 왼쪽으로 이동
            else if (compResult < 0) {
                current = current.left;
                if (current == null) {
                    parent.left = new Node<>(e);
                    size++;
                    return true;
                }
            }
            // 입력값이 더 크면 오른쪽으로 이동
            else {
                current = current.right;
                if (current == null) {
                    parent.right = new Node<>(e);
                    size++;
                    return true;
                }
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        if (root == null || o == null) return false;

        E target = (E) o;
        Node<E> current = root;

        // 루트부터 시작하여 값을 비교하며 탐색
        while (current != null) {
            int result = compare(target, current.value);

            if (result == 0) {
                return true; // 값 발견
            } else if (result < 0) {
                current = current.left; // 왼쪽 서브트리로 이동
            } else {
                current = current.right; // 오른쪽 서브트리로 이동
            }
        }
        return false; // 탐색 실패
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        if (root == null || o == null) return false;

        int oldSize = size;
        // 재귀 메서드를 호출하여 삭제 수행 후, 변경된 루트 노드를 받아옴
        root = deleteNode(root, (E) o);

        // 삭제 전후 사이즈 비교를 통해 성공 여부 반환
        return size < oldSize;
    }

    // 노드 삭제 내부 로직 (재귀 방식)
    private Node<E> deleteNode(Node<E> node, E target) {
        // 종료 조건: 삭제할 노드를 찾지 못한 경우
        if (node == null) return null;

        int cmp = compare(target, node.value);

        // 1. 탐색 단계: 타겟이 현재 노드보다 작으면 왼쪽, 크면 오른쪽으로 재귀 호출
        if (cmp < 0) {
            node.left = deleteNode(node.left, target);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, target);
        }
        // 2. 삭제 단계: 타겟 노드 발견
        else {
            size--;

            // Case 1: 자식 노드가 없는 경우 (Leaf Node)
            if (node.left == null && node.right == null) {
                return null; // 해당 노드 제거
            }
            // Case 2: 오른쪽 자식만 있는 경우
            else if (node.left == null) {
                return node.right; // 오른쪽 자식을 현재 위치로 대체
            }
            // Case 2: 왼쪽 자식만 있는 경우
            else if (node.right == null) {
                return node.left; // 왼쪽 자식을 현재 위치로 대체
            }
            // Case 3: 자식 노드가 둘 다 있는 경우
            else {
                // 오른쪽 서브트리에서 가장 작은 값(Successor)을 찾음
                Node<E> successor = getMinNode(node.right);

                // 현재 노드의 값을 후계자의 값으로 교체 (구조 변경 없이 값만 변경)
                node.value = successor.value;

                // 아래 재귀 호출에서 후계자 노드 삭제 시 size가 한 번 더 감소하므로, 이를 보정하기 위해 증가
                size++;

                // 값을 가져온 후계자 노드는 오른쪽 서브트리에서 삭제
                node.right = deleteNode(node.right, successor.value);
            }
        }
        return node; // 변경된 트리 구조 반환
    }

    // 서브트리의 최솟값 노드 탐색 (왼쪽 끝까지 이동)
    private Node<E> getMinNode(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 전위 순회 (Pre-Order): Root -> Left -> Right
    @Override
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node<E> node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }

    // 중위 순회 (In-Order): Left -> Root -> Right (정렬된 순서 보장)
    @Override
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<E> node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.print(node.value + " ");
        inOrderRec(node.right);
    }

    // 후위 순회 (Post-Order): Left -> Right -> Root
    @Override
    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node<E> node) {
        if (node == null) return;
        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.value + " ");
    }

    // 레벨 순회 (Level-Order): 층별 순회 (Queue 사용)
    @Override
    public void levelOrder() {
        if (root == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<E> current = queue.poll();
            System.out.print(current.value + " ");

            // 왼쪽 자식 먼저 큐에 추가
            if (current.left != null) queue.add(current.left);
            // 오른쪽 자식 큐에 추가
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        root = null; // 루트 참조를 제거하면 GC에 의해 메모리 해제
        size = 0;
    }
}