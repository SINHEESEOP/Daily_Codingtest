package datastructures.list.LinkedList;

import datastructures.list.MyDeque;
import datastructures.list.MyList;

import java.util.NoSuchElementException;

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
        if (e == null) throw new NullPointerException();
        if (head == null) {
            head = tail = new Node<>(e);
            size++;
            return;
        }

        Node<E> temp = head;
        head = new Node<>(e);
        head.next = temp;
        size++;
    }

    @Override
    public E getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public E removeFirst() {
        if (head == null) throw new NoSuchElementException();
        if (size == 1) tail = null;

        Node<E> temp = head;
        head = head.next;
        size--;
        return  temp.value;
    }

    @Override
    public void addLast(E e) {
        if (tail == null) {
            head = tail =  new Node<>(e);
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.value;
    }

    @Override
    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();

        Node<E> temp;
        if (size == 1) {
            temp = head;
            head = tail = null;
            size--;
            return temp.value;
        }

        temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        E val = tail.value;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    @Override
    public E get(int index) {
        if (size == 0) throw new NoSuchElementException();
        if (size - 1 < index || 0 > index) throw new IndexOutOfBoundsException();

        Node <E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    @Override
    public int size() {
        return size;
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
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        E oldValue = temp.value;
        temp.value = e;
        return oldValue;
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
