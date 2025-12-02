package datastructures.list.linkedList_pass;

import datastructures.list.MyList;

/**
 * 이거 단방향 리스트라, MyDeque 는 상속받을 필요 X
 * 단반향도 맨앞과 맨뒤에 연산이 가능하지만, 맨뒤에 넣거나 삭제하는 경우 효율 X
 * 양방향에서 둘다 구현 하는 걸로.
 */
public class MySinglyLinkedList_pass<E> implements MyList<E> {

    private Node<E> head, tail;
    private int size;

    private static class Node<E> {
        E value;

        Node<E> next;

        Node(E v) {
            value = v;
        }
    }

    // [중복 제거 1] 노드 탐색 로직 공통화
    private Node<E> getNode(int index) {
        Node<E> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    // [중복 제거 2] 범위 체크 로직 공통화
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkNull(Object obj) {
        if (obj == null) throw new NullPointerException();
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return getNode(index).value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        checkNull(e);

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
        checkNull(e);
        checkPositionIndex(index);

        if (index == 0) {
            Node<E> newNode = new Node<>(e); // 변수명 가독성 좋게 변경
            newNode.next = head;
            head = newNode;

            if (size == 0) { // size가 0이었다면 tail도 head를 가리킴
                tail = head;
            }
            size++;
            return;
        }

        Node<E> prevNode = getNode(index - 1);

        Node<E> newNode = new Node<>(e);
        Node<E> nextNode = prevNode.next;

        prevNode.next = newNode;
        newNode.next = nextNode;

        // 맨 뒤에 추가된 경우 tail 갱신
        if (newNode.next == null) { // (size == index)와 같은 의미
            tail = newNode;
        }

        size++;
    }

    @Override
    public E set(int index, E e) {
        checkNull(e);
        checkElementIndex(index);

        Node<E> temp = getNode(index);
        E oldValue = temp.value;
        temp.value = e;
        return oldValue;
    }

    // 개선해보기
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }

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

    //
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
            temp = temp.next;
            index++;
        }
        return -1;
    }

}
