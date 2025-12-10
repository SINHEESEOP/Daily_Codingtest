package datastructures.tree;

/**
 * 트리가 가져야 할 가장 기본 기능과, 이진 트리의 특징(순회)을 정의합니다.
 */
public interface MyTree<E> {

    boolean add(E e);       // 요소 추가
    boolean remove(Object o); // 요소 삭제
    boolean contains(Object o); // 요소 검색
    int size();             // 크기 반환
    boolean isEmpty();      // 비어있는지 확인
    void clear();           // 초기화

}