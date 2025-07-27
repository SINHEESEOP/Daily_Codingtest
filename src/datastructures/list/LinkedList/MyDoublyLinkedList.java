package datastructures.list.LinkedList;

import datastructures.list.MyDeque;
import datastructures.list.MyList;

import java.util.NoSuchElementException;

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
        // 다시
        return null;
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
        return 0;
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
        return null;
    }

    @Override
    public E removeFirst() {
        return null;
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
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    private Node<E> extractedNode(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

}
