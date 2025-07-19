package datastructures.list.LinkedList;

import datastructures.list.MyList;

import java.util.NoSuchElementException;

/**
 * 이거 단방향 리스트라, MyDeque 는 상속받을 필요 X
 * 단반향도 맨앞과 맨뒤에 연산이 가능하지만, 맨뒤에 넣거나 삭제하는 경우 효율 X
 * 양방향에서 둘다 구현 하는 걸로.
 */
public class MySinglyLinkedList<E> implements MyList<E> {

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
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node <E> temp;
        if (size == 1) {
            temp = head;
            head = tail = null;
            size--;
            return temp.value;
        }

        if (index == 0) {
            temp = head;
            head = temp.next;
            size--;
            return temp.value;
        }

        temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<E> result = temp.next;

        if(temp.next.next == null){
            temp.next = null;
            tail = temp;
        } else {
            temp.next = temp.next.next;
        }
        size--;
        return result.value;
    }

    // 그려보면서 이해해야 할 듯
    public E remove2(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }

        Node<E> removedNode;
        if (index == 0) {
            // 맨 앞 요소 삭제
            removedNode = head;
            head = head.next;
            if (head == null) {
                // 리스트가 비게 되면 tail도 null 처리
                tail = null;
            }
        } else {
            // 삭제할 노드의 이전 노드(prev)를 찾음
            Node<E> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            removedNode = prev.next;
            prev.next = removedNode.next;
            if (removedNode == tail) {
                // 마지막 노드 삭제 시 tail 갱신
                tail = prev;
            }
        }

        size--;
        return removedNode.value;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) return -1;

        Node<E> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.value != null && temp.value.equals(o)) return index;
            index++;
        }
        return -1;
    }

}
