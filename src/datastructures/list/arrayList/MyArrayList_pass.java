package datastructures.list.arrayList;

import datastructures.list.MyList;

public class MyArrayList_pass<E> implements MyList<E> {

    // clear 와 contains 는 디폴트로 구현 안해도 된다 캅니다.

    // 내부 필드
    private Object[] elementData;
    private int size;

    // 생성자
    public MyArrayList_pass() {
        this.elementData = new Object[10]; // 디폴트 초기 용량 (자바 ArrayList도 기본 10)
        this.size = 0;
    }

    public MyArrayList_pass(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.size = 0;
    }

    // ------ 조회 ------
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    // ------ 삽입 ------
    @Override
    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    @Override
    public void add(int index, E e) {
        rangeCheckForAdd(index);          // ← index == size 허용
        ensureCapacity(size + 1);         // ← 필요 시만 확장

        // 뒤로 한 칸 밀기: [index .. size-1] → [index+1 .. size]
        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index, elementData, index + 1, numMoved);
        }

        elementData[index] = e;
        size++;
    }

    // ------ 수정 ------
    @Override
    public E set(int index, E e) {
        rangeCheck(index);
        @SuppressWarnings("unchecked")
        E oldValue = get(index);
        elementData[index] = e;
        return oldValue;
    }

    // ------ 삭제 ------
    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = get(index); // 1. 삭제할 값 백업

        // 2. 삭제할 인덱스 다음부터 끝까지 반복하며 한 칸씩 앞으로 당김
        // 예: index가 2라면, elementData[2]에 elementData[3]을 넣음
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        // 3. [중요] 마지막 칸 비우기 (메모리 누수 방지) & 사이즈 줄이기
        elementData[--size] = null;

        return oldValue;
    }

    // ------ 탐색 ------
    @Override
    public int indexOf(Object o) {
        if (o == null) {
            // 찾는 값이 null일 때는 == 으로 비교
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) return i;
            }
        } else {
            // 객체일 때는 equals로 비교
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) return i;
            }
        }
        return -1;
    }


    // [기존] 조회/삭제/수정용 (index == size 불가능)
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // [신규] 삽입(Add)용 (index == size 허용)
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) { // index == size는 허용해야 함
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // 공간 다 차면 두배 늘려주는 함수
    private void ensureCapacity(int minCapacity) {
        if (elementData.length < minCapacity) {
            int newCap = (elementData.length == 0) ? 10 : elementData.length * 2;
            if (newCap < minCapacity) newCap = minCapacity;
            elementData = java.util.Arrays.copyOf(elementData, newCap);
        }
    }


}
