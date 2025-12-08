package datastructures.Queue.deque;

// 굳이 이건 링크드 리스트 만들때 다 했던거라 배열로 할뿐... 비효율적 굳이 안해도 될 듯.
// 트리 / 힙 / 프올큐 순으로 넘어감
public class MyArrayDeque implements MyDeque{
    @Override
    public void addFirst(Object o) {

    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object removeFirst() {
        return null;
    }

    @Override
    public void addLast(Object o) {

    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object removeLast() {
        return null;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
