package datastructures.Queue;

// 기본적으로 Queue 에 확장이 Deque 이지만, 굳이 Queue 를 만들어서 상속하지 않았다.
// 대신 그래서 큐 패키지 하위에 두었다.

/**
 * 현재 LinkedList 에서 implement 하고 있다. -> 링크드 리스트는 Queue 와 List 를 둘 다 구현하고 있다.
 */
public interface MyDeque<E> {

    // 앞쪽 연산
    void addFirst(E e);
    E getFirst();          // empty ⇒ NoSuchElementException
    E removeFirst();       // empty ⇒ NoSuchElementException

    // 뒤쪽 연산
    void addLast(E e);
    E getLast();           // empty ⇒ NoSuchElementException
    E removeLast();        // empty ⇒ NoSuchElementException
}
