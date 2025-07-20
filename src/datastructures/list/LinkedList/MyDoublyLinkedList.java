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
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(E e) {

    }

    @Override
    public void add(int index, E e) {

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
