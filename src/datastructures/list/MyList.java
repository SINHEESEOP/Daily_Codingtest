package datastructures.list;

public interface MyList<E> {

    // ------ 조회 ------
    E get(int index);          // IndexOutOfBoundsException
    int size();                // 현재 요소 수
    default boolean isEmpty() {
        return size() == 0;
    }

    // ------ 삽입 ------
    void add(E e);             // 맨 뒤에 추가
    void add(int index, E e);  // index 위치에 삽입 (0 ≤ index ≤ size)

    // ------ 수정 ------
    E set(int index, E e);     // index 위치 값을 e로 교체, 이전 값 반환

    // ------ 삭제 ------
    E remove(int index);       // index 위치 노드 제거 & 값 반환

    // ------ 탐색 ------
    int indexOf(Object o);     // 첫 번째 등장 위치, 없으면 -1

}
