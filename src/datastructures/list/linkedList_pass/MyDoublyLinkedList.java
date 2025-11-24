package datastructures.list.linkedList_pass;

import datastructures.Queue.MyDeque;
import datastructures.list.MyList;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 1. extractedNode 개선
 * 2. add, addLast 리팩토링
 * 3. removeLast 의 치명적 결함 수정.
 */
public class MyDoublyLinkedList<E> implements MyDeque<E>, MyList<E> {

    private static class Node<E> {
        E value;

        Node<E> next, prev;

        Node(E v) {
            value = v;
        }
    }

    private Node<E> head, tail;
    private int size;

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<E> temp = extractedNode(index);
        return temp.value;
    }

    @Override
    public int size() {
        return size;
    }

    // add 와, addLast 잘 생각해보고 리팩토링
    @Override
    public void add(E e) {
        if (e == null) throw new NullPointerException();
        if (size == 0) {
            head = new Node<>(e);
            tail = head;
            size++;
            return;
        }

        tail.next = new Node<>(e);
        tail = tail.next;
        size++;
    }

    @Override
    public void add(int index, E e) {
        // 내일 다시 어떤 조건들이 있는지 어떤 분기가 있느지, 어떤 예외가 있는지 먼저 분석 구상하고 코드 짜기.
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (e == null) throw new NullPointerException();

        if (index == size) {
            addLast(e);
            return;
        }

        if (index == 0) {
            addFirst(e);
            return;
        }

        Node<E> cur = extractedNode(index);
        Node<E> prev = cur.prev;
        Node<E> newNode = new Node<>(e);

        prev.next = newNode;
        newNode.prev = prev;

        newNode.next = cur;
        cur.prev = newNode;
        size++;
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (e == null) throw new NullPointerException();

        Node<E> cur = extractedNode(index);
        E result = cur.value;
        cur.value = e;

        return result;
    }

    @Override
    public E remove(int index) {
        // 이것도 다시.
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (size == 0) throw new NoSuchElementException();

        Node<E> temp = head;
        if (index == 0) {
            head = temp.next;
            size--;
            return temp.value;
        }

        if (index == size - 1) {
            temp = tail;
            tail = temp.prev;
            size--;
            return temp.value;
        }

        temp = extractedNode(index);
        Node<E> prev = temp.prev;

        if (temp.next == null) {
            prev.next = null;
            tail = prev;
            size--;
            return temp.value;
        }

        prev.next = temp.next;
        temp.next.prev = prev;
        size--;
        return temp.value;
    }

    @Override
    public int indexOf(Object o) {

        int index = 0;
        for (Node<E> temp = head; temp != null; temp = temp.next) {
            if (Objects.equals(o, temp.value)) return index;
            index++;
        }
        return -1;
    }


    public int indexOf2(Object o) {
        int idx = 0;
        for (Node<E> curr = head; curr != null; curr = curr.next) {
            if (o == null ? curr.value == null : o.equals(curr.value)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    @Override
    public void addFirst(E e) {
        if (e == null) throw new NullPointerException();

        if (size == 0) {
            head = new Node<>(e);
            tail = head;
            size++;
            return;
        }

        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    @Override
    public E getFirst() {
        if (size == 0) throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();

        E temp = head.value;

        if (size == 1) {
            head = tail = null;
            size--;
            return temp;
        }

        head = head.next;
        size--;
        return temp;
    }

    @Override
    public void addLast(E e) {
        if (e == null) throw new NullPointerException();

        if (size == 0) {
            head = new Node<>(e);
            tail = head;
            size++;
            return;
        }

        Node<E> newNode = new Node<>(e);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public E getLast() {
        if (size == 0) throw new NoSuchElementException();
        return tail.value;
    }

    @Override
    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();

        if (size == 1) {
            return removeFirst();
        }

        E temp = tail.value;
        tail = tail.prev;
        // 이런 디테일 중요함. 항상 생각을 여러번 하셈.
        // 일부러 지웠음, 디테일 코드 너가 채워 넣어보셈. 부족한게 하나 있음.

        //
        size--;
        return temp;
    }

    // 현재 앞에서부터 조회, 성능 2배 올릴 수 있는 방법 있음
    private Node<E> extractedNode(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

}
