package datastructures.list.vector;

import datastructures.list.MyList;

/**
 * MyVector는 동적 배열 기반의 자료구조로,
 * 요소들을 순차적으로 저장하며 필요 시 자동으로 배열 크기를 늘릴 수 있습니다.
 * <p>
 * 주요 특징:
 * - 내부적으로 배열(Object[])을 사용하여 요소를 관리합니다.
 * - 요소의 추가(add), 조회(get), 수정(set), 삭제(remove) 등 기본 List 연산을 지원합니다.
 * - 요소가 가득 차면 자동으로 더 큰 배열로 복사하여 확장합니다(동적 확장).
 * - 배열 기반이므로 인덱스 접근이 빠르며(랜덤 액세스), 삽입/삭제는 느릴 수 있습니다.
 * - Java 표준 Vector와 유사하나, 동기화(synchronized)는 기본 지원하지 않습니다.
 * - MyList 인터페이스를 구현하여 List 계열 자료구조와 호환됩니다.
 * <p>
 * 실질적으로 ArrayList와 유사하지만, 필요 시 Vector처럼 Stack 등에서 상속하여 사용할 수 있습니다.
 */
public class MyVector<E> implements MyList<E> {

    // 내부 데이터를 저장하는 배열
    protected Object[] elementData;

    // 저장된 요소의 수
    protected int size;

    // 기본 생성자: 기본 용량으로 배열 초기화
    public MyVector() {
        this.elementData = new Object[10];
        this.size = 0;
    }

    // 초기 용량 지정 생성자
    public MyVector(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.size = 0;
    }

    // 지정한 인덱스의 요소를 반환
    @Override
    public E get(int index) {
        // 범위 검사
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // E 타입으로 캐스팅하여 반환
        @SuppressWarnings("unchecked")
        E value = (E) elementData[index];
        return value;
    }


    // 저장된 요소의 개수를 반환
    @Override
    public int size() {
        return this.size;
    }

    // 맨 뒤에 요소 추가
    @Override
    public void add(E e) {
        if (e == null) throw new NullPointerException();
        ensureCapacity();
        elementData[size++] = e;
    }

    // 지정한 위치에 요소 삽입
    @Override
    public void add(int index, E e) {
        if (e == null) throw new NullPointerException();
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        ensureCapacity();

        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = e;
        size++;

    }

    // 지정한 위치의 요소를 새로운 값으로 교체하고, 이전 값을 반환
    @Override
    public E set(int index, E e) {
        if (e == null) throw new NullPointerException();
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        E result = get(index);
        elementData[index] = e;

        return result;
    }

    // 지정한 위치의 요소를 제거하고, 제거한 값을 반환
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        @SuppressWarnings("unchecked")
        E value = (E) elementData[index];

        // 올바른 방향: 인덱스(삭제된 곳)부터 끝까지 정방향 순회
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        // 2. [필수] 사이즈 줄이기 & 마지막 칸 비우기 (추가 필요!)
        size--;                 // 사이즈를 1 줄임 (이제 size는 유효한 데이터의 끝을 가리킴)
        elementData[size] = null; // 마지막에 남은 중복 데이터(찌꺼기)를 삭제 (메모리 누수 방지)

        return value;
    }

    // 주어진 객체와 같은 값을 갖는 첫 번째 요소의 인덱스를 반환 (없으면 -1)
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) return i;
        }
        return -1;
    }


    protected void ensureCapacity() {
        if (size == elementData.length) {
            Object[] newData = new Object[elementData.length * 2];
//            System.arraycopy(elementData, 0, newData, 0, size);
            for (int i = 0; i < size; i++) {
                newData[i] = elementData[i];
            }
            elementData = newData;
        }
    }
}
