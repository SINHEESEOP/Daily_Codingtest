package datastructures.list.vector.stack;

import datastructures.list.vector.MyVector_pass;

import java.util.EmptyStackException;

/**
 * 4 . 알아두면 좋은 점 (TMI)
 * 자바의 Stack 클래스는 역사적인 이유로 Vector를 상속받았지만, 현대 자바에서는 **"잘못된 설계"**로 간주합니다.
 * 이유: Vector의 모든 메서드가 synchronized(동기화) 되어 있어 무겁고, 스택인데 중간에 add(0, val) 같은 걸로 끼워 넣기가 가능해져서 스택의 원칙(LIFO)이 깨질 수 있기 때문입니다.
 * 현업: 그래서 실무에서는 Stack 클래스 대신 Deque(ArrayDeque) 인터페이스를 사용하는 것을 권장합니다.
*/
public class MyStack_pass<E> extends MyVector_pass<E> {

    // 기본 생성자
    public MyStack_pass() {
        super();
    }

    // 초기 용량 지정 생성자
    public MyStack_pass(int initialCapacity) {
        super(initialCapacity);
    }

    // 스택 맨 위에 요소 추가(push)
    // 반환값: 추가된 요소
    public E push(E item) {
        if (item == null) throw new NullPointerException();
        super.add(item);
        return item;
    }

    // 스택 맨 위의 요소를 제거하고 반환(pop)
    // 스택이 비어있으면 예외 발생
    public E pop() {
        if (empty()) throw new EmptyStackException();
        return super.remove(size() - 1);
    }

    // 스택 맨 위의 요소를 제거하지 않고 반환(peek)
    // 스택이 비어있으면 예외 발생
    public E peek() {
        if (empty()) throw new EmptyStackException();
        return super.get(size() - 1);
    }

    // 스택이 비어있으면 true 반환, 아니면 false 반환
    public boolean empty() {
        return size == 0;
    }

    // 주어진 객체와 같은 값을 갖는 요소가 스택 내에서 맨 위에서 몇 번째(1-base)인지 반환
    // (없으면 -1)
    public int search(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(o)) return size - i;
        }
        return -1;
    }
}
