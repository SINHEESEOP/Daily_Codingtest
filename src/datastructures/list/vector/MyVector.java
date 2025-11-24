package datastructures.list.vector;

import datastructures.list.MyList;

/**
 * MyVector는 동적 배열 기반의 자료구조로,
 * 요소들을 순차적으로 저장하며 필요 시 자동으로 배열 크기를 늘릴 수 있습니다.
 *
 * 주요 특징:
 * - 내부적으로 배열(Object[])을 사용하여 요소를 관리합니다.
 * - 요소의 추가(add), 조회(get), 수정(set), 삭제(remove) 등 기본 List 연산을 지원합니다.
 * - 요소가 가득 차면 자동으로 더 큰 배열로 복사하여 확장합니다(동적 확장).
 * - 배열 기반이므로 인덱스 접근이 빠르며(랜덤 액세스), 삽입/삭제는 느릴 수 있습니다.
 * - Java 표준 Vector와 유사하나, 동기화(synchronized)는 기본 지원하지 않습니다.
 * - MyList 인터페이스를 구현하여 List 계열 자료구조와 호환됩니다.
 *
 * 실질적으로 ArrayList와 유사하지만, 필요 시 Vector처럼 Stack 등에서 상속하여 사용할 수 있습니다.
 */
public class MyVector<E> implements MyList<E> {

    // 내부 데이터를 저장하는 배열
    protected Object[] elementData;

    // 저장된 요소의 수
    protected int size;

    // 기본 생성자: 기본 용량으로 배열 초기화
    public MyVector() {

    }

    // 초기 용량 지정 생성자
    public MyVector(int initialCapacity) {

    }

    // 지정한 인덱스의 요소를 반환
    @Override
    public E get(int index) { return null; }

    // 저장된 요소의 개수를 반환
    @Override
    public int size() { return 0; }

    // 맨 뒤에 요소 추가
    @Override
    public void add(E e) { }

    // 지정한 위치에 요소 삽입
    @Override
    public void add(int index, E e) { }

    // 지정한 위치의 요소를 새로운 값으로 교체하고, 이전 값을 반환
    @Override
    public E set(int index, E e) { return null; }

    // 지정한 위치의 요소를 제거하고, 제거한 값을 반환
    @Override
    public E remove(int index) { return null; }

    // 주어진 객체와 같은 값을 갖는 첫 번째 요소의 인덱스를 반환 (없으면 -1)
    @Override
    public int indexOf(Object o) { return -1; }
}
