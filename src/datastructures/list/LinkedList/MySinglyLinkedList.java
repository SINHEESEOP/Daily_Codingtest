package datastructures.list.LinkedList;

import datastructures.list.MyDeque;
import datastructures.list.MyList;

public class MySinglyLinkedList<E> implements MyList<E>, MyDeque<E> {

    private Node<E> head, tail;
    private int size;

    private static class Node<E> {
        E value;

        Node<E> next;

        Node(E v) {
            value = v;
        }
    }

    @Override
    public void addFirst(E e) {

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

    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E get(int index) {
        Node<E> node = head;
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(E e) {
        if (e == null) throw new NullPointerException();

        if (head == null) {
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
        if (e == null)
            throw new NullPointerException();

        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            Node<E> tempNode = head;
            head = new Node<>(e);
            head.next = tempNode;
            size++;
            if (size == 1) tail = head;
            return;
        }

        Node<E> tempNode = head;
        for (int i = 0; i < index - 1; i++) {
            tempNode = tempNode.next;
        }
        Node<E> prevNode = tempNode;
        Node<E> nextNode = tempNode.next;

        prevNode.next = new Node<>(e);
        prevNode.next.next = nextNode;

        if (size == index) {
            tail = prevNode.next;
        }

        size++;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

}
