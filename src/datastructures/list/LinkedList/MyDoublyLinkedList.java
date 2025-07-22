package datastructures.list.LinkedList;

import datastructures.list.MyDeque;
import datastructures.list.MyList;

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


    }

    private Node<E> extractedNode(int index) {
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
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
}
