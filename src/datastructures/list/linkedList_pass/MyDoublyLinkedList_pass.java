package datastructures.list.linkedList_pass;

import datastructures.Queue.MyDeque;
import datastructures.list.MyList;

public class MyDoublyLinkedList_pass<E> implements MyDeque<E>, MyList<E> {

    final String ADD = "add";
    final String SET = "set";
    final String GET = "get";
    final String REMOVE = "remove";

    private static class Node<E> {
        E value;

        Node<E> next, prev;

        Node(E v) {
            value = v;
        }
    }

    private Node<E> head, tail;
    private int size;

    private void nullCheck(E e) {
        if (e == null) throw new NullPointerException();
    }

    private void checkNodeSize() {
        if (size == 0) throw new NullPointerException();
    }

    private void checkIndexBounds(int index, String code) {
        if ((index < 0 || index > size) && code.equals(ADD)) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }

        if ( (index < 0 || index >= size) &&
                (code.equals(SET) || code.equals(GET) || code.equals(REMOVE) ) ) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }

    private Node<E> search(int index) {
        checkNodeSize();
        checkIndexBounds(index, GET);

        if (index == 0) return head;
        if (index == size - 1) return tail;


        if (index < size / 2) {
            Node<E> x = head;
            for (int i = 0; i < index; i++) {
                x = x.next; // 앞으로 전진
            }
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev; // 뒤로 후진
            }
            return x;
        }
    }

    private void linkFirstNode(E e) {
        head = tail = new Node<>(e);
        size++;
    }

    // prev와 next는 모두 null이 아닌, 서로 인접한 노드라고 가정
    private void linkBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newNode = new Node<>(e);
        newNode.next = next;
        newNode.prev = prev;

        prev.next = newNode;
        next.prev = newNode;

        size++;
    }

    @Override
    public void addFirst(E e) {
        nullCheck(e);

        if (size == 0) {
            linkFirstNode(e);
            return;
        }

        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

        size++;
    }

    @Override
    public void addLast(E e) {
        nullCheck(e);

        if (size == 0) {
            linkFirstNode(e);
            return;
        }

        Node<E> newNode = new Node<>(e);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;

        size++;
    }

    @Override
    public void add(E e) {
        nullCheck(e);
        addLast(e);
    }

    @Override
    public void add(int index, E e) {
        nullCheck(e);
        checkIndexBounds(index, ADD);

        if (index == 0) {
            addFirst(e);
            return;
        }

        if (index == size) {
            addLast(e);
            return;
        }

        // 중간 추가
        Node<E> prev = search(index - 1);
        Node<E> next = prev.next;
        linkBetween(e, prev, next);
    }

    @Override
    public E set(int index, E e) {
        nullCheck(e);
        checkIndexBounds(index, SET);

        Node<E> node = search(index);
        E result = node.value;
        node.value = e;

        return result;
    }

    @Override
    public E getFirst() {
        checkNodeSize();
        return head.value;
    }

    @Override
    public E getLast() {
        checkNodeSize();
        return tail.value;
    }

    @Override
    public E get(int index) {
        checkIndexBounds(index, GET);
        return search(index).value;
    }

    @Override
    public E removeFirst() {
        checkNodeSize();

        E result = head.value;
        Node<E> newHead = head.next;

        if (newHead == null) {
            head = tail = null;
        } else {
            newHead.prev = null;
            head.next = null;
            head.value = null;
            head = newHead;
        }
        size--;
        return result;
    }

    @Override
    public E removeLast() {
        checkNodeSize();

        E result = tail.value;
        Node<E> newTail = tail.prev;

        if (newTail == null) {
            head = tail = null;
        } else {
            newTail.next = null;
            tail.prev = null;
            tail.value = null;
            tail = newTail;
        }
        size--;
        return result;
    }

    @Override
    public E remove(int index) {
        checkIndexBounds(index, REMOVE);

        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        // 중간 삭제
        Node<E> removeNode = search(index);
        E result = removeNode.value;

        removeNode.prev.next = removeNode.next;
        removeNode.next.prev = removeNode.prev;

        removeNode.prev = null;
        removeNode.next = null;
        removeNode.value = null;

        size--;

        return result;
    }

    @Override
    public boolean offer(E e) {
        try {
            addLast(e);
            return true; // "성공적으로 넣었어"
        } catch (OutOfMemoryError error) {
            // 혹시라도 진짜 메모리가 터져서 에러가 나면
            return false; // 에러 내지 말고 false 반환
        }
    }

    @Override
    public E poll() {
        if (size == 0) return null;
        return removeFirst();
    }

    @Override
    public E peek() {
        if (size == 0) return null;
        return getFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0; // 0번부터 카운트 시작

        // Case 1: 찾는 값이 null일 때 (== 비교)
        if (o == null) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.value == null) {
                    return index; // 찾았다! 현재 인덱스 반환
                }
                index++;
            }
        }
        // Case 2: 찾는 값이 객체일 때 (.equals 비교)
        else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (o.equals(x.value)) { // 객체끼리는 equals로 비교
                    return index; // 찾았다!
                }
                index++;
            }
        }

        // 끝까지 돌았는데 없으면 -1 반환 (국룰)
        return -1;
    }

}
