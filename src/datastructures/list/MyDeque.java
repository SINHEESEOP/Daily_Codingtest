package datastructures.list;

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
