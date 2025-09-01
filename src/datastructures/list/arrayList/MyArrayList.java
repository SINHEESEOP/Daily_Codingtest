package datastructures.list.arrayList;

import datastructures.list.MyList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    // 내부 필드
    private Object[] elementData;
    private int size;

    // 생성자
    public MyArrayList() {
        this.elementData = new Object[10]; // 디폴트 초기 용량 (자바 ArrayList도 기본 10)
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
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
        rangeCheck(index);          // ← index == size 허용
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
        return null;
    }

    // ------ 삭제 ------
    @Override
    public E remove(int index) {
        return null;
    }
    // (clear는 default라 구현 생략 가능)

    // ------ 탐색 ------
    @Override
    public int indexOf(Object o) {
        return -1;
    }
    // (contains도 default라 구현 생략 가능)


    // ---- Utility Method ----
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (elementData.length < minCapacity) {
            int newCap = (elementData.length == 0) ? 10 : elementData.length * 2;
            if (newCap < minCapacity) newCap = minCapacity;
            elementData = java.util.Arrays.copyOf(elementData, newCap);
        }
    }

}
