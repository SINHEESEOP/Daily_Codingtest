package datastructures.list.vector.stack;

import datastructures.list.vector.MyVector;

public class MyStack_ing<E> extends MyVector<E> {

    // 기본 생성자
    public MyStack_ing() { }

    // 초기 용량 지정 생성자
    public MyStack_ing(int initialCapacity) { }

    // 스택 맨 위에 요소 추가(push)
    // 반환값: 추가된 요소
    public E push(E item) { return null; }

    // 스택 맨 위의 요소를 제거하고 반환(pop)
    // 스택이 비어있으면 예외 발생
    public E pop() { return null; }

    // 스택 맨 위의 요소를 제거하지 않고 반환(peek)
    // 스택이 비어있으면 예외 발생
    public E peek() { return null; }

    // 스택이 비어있으면 true 반환, 아니면 false 반환
    public boolean empty() { return false; }

    // 주어진 객체와 같은 값을 갖는 요소가 스택 내에서 맨 위에서 몇 번째(1-base)인지 반환
    // (없으면 -1)
    public int search(Object o) { return -1; }
}
