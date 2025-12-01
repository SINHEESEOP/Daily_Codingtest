package datastructures.Queue;

public interface MyQueue<E> {
    // 큐의 핵심 기능 3가지 (FIFO)

    // 1. 넣기 (뒤로 줄 서기)
    // - 공간이 없으면 예외를 던지거나 false 반환 (여기선 void/true로 가정)
    boolean offer(E e);

    // 2. 꺼내기 (맨 앞 사람 나가기)
    // - 비어있으면 null 반환 (poll) vs 예외 발생 (remove) 중 선택
    E poll();

    // 3. 확인하기 (맨 앞 사람 누구?)
    // - 비어있으면 null 반환 (peek) vs 예외 발생 (element) 중 선택
    E peek();
}