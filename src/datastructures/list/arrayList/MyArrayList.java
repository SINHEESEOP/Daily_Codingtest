package datastructures.list.arrayList;

import datastructures.list.MyList;

public class MyArrayList<E> implements MyList<E> {

    // 내부 필드
    private Object[] elementData;
    private int size;

    // 생성자
    public MyArrayList() { }
    public MyArrayList(int initialCapacity) { }

    // ------ 조회 ------
    @Override
    public E get(int index) { return null; }
    @Override
    public int size() { return 0; }

    // ------ 삽입 ------
    @Override
    public void add(E e) { }
    @Override
    public void add(int index, E e) { }

    // ------ 수정 ------
    @Override
    public E set(int index, E e) { return null; }

    // ------ 삭제 ------
    @Override
    public E remove(int index) { return null; }
    // (clear는 default라 구현 생략 가능)

    // ------ 탐색 ------
    @Override
    public int indexOf(Object o) { return -1; }
    // (contains도 default라 구현 생략 가능)

}
