package datastructures.tree.array;

import datastructures.tree.MyBinaryTree;
import java.util.Arrays;

public class MyCompleteBinaryTree<E> implements MyBinaryTree<E> {

    private Object[] array; // 노드 대신 배열 사용
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyCompleteBinaryTree() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // [인덱스 공식 Helper] - 1번 인덱스 시작 기준이라고 가정 (0번은 비워둠)
    // 0번부터 시작하려면 공식을 바꿔야 합니다.
    private int getParent(int index) { return index / 2; }
    private int getLeftChild(int index) { return index * 2; }
    private int getRightChild(int index) { return index * 2 + 1; }

    @Override
    public boolean add(E e) {
        // TODO: 완전 이진 트리는 '왼쪽부터 채움'
        // 즉, 배열의 size + 1 인덱스에 값 넣으면 끝.
        // (배열 꽉 차면 resize 필요)
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // 보통 완전 이진 트리는 중간 삭제를 잘 안 함 (힙에서는 pop만 함)
        // 구현한다면 맨 뒤 요소를 가져와서 채우는 방식을 사용
        return false;
    }

    @Override
    public boolean contains(Object o) {
        // TODO: 배열이니까 for문 돌면서 찾으면 됨 (단순 선형 탐색)
        return false;
    }

    // 순회 구현 (배열 인덱스로 재귀 호출)
    @Override
    public void preOrder() {
        // TODO: traversePreOrder(1) 호출
    }

    @Override
    public void inOrder() {
        // TODO: traverseInOrder(1) 호출
    }

    @Override
    public void postOrder() {
        // TODO: traversePostOrder(1) 호출
    }

    @Override
    public void levelOrder() {
        // TODO: 배열 자체가 이미 레벨 오더 순서대로 저장되어 있음!
        // 그냥 for문 1부터 size까지 출력하면 됨 (개이득)
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }
}