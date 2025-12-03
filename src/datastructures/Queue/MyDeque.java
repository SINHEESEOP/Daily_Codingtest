package datastructures.Queue;

/**
 * 현재 MySinglyLinkedList, MyDoublyLinkedList 에서 implement 한 상태임.
 * 이유 : 링크드 리스트는 Queue 와 List 를 둘다 상속받는 구조임. (정확히는 둘다 구현하는 구조)
 */

// [변경점] extends MyQueue<E> 추가!
public interface MyDeque<E> extends MyQueue<E> {

    // ----------------------------------------------------
    // 1. MyQueue 의 메서드들을 상속받음 (offer, poll, peek)
    //    -> 구현체에서 이 메서드들을 '어떻게' 처리할지 매핑해줘야 함
    // ----------------------------------------------------

    // 2. Deque 만의 고유 기능 (앞뒤 자유자재)

    // 앞쪽 연산
    void addFirst(E e);
    E getFirst();
    E removeFirst();

    // 뒤쪽 연산
    void addLast(E e);
    E getLast();
    E removeLast();
}




