package com.hzw.linkedlist.d_implement_stack_in_linkedlist;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;
    public LinkedListStack(){
        linkedList = new LinkedList<E>();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeFirst();
    }

    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: top");
        stringBuilder.append(linkedList.toString());
        return stringBuilder.toString();
    }
}
