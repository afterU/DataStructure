package com.hzw.linkedlist.h_bothway_linkedlist;

public class LinkedList<E> {
    private class Node{
        private E e;
        private Node next;
        private Node pre;

        public Node(E e, Node next,Node pre){
            this.e = e;
            this.next = next;
            this.pre = pre;
        }

        public Node(E e){this(e,null,null);}

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public LinkedList(E e){
        if (e == null){
            this.head = null;
            this.tail = null;
            size = 0;
        }else{
            this.head = new Node(e);
            this.tail = this.head;
            size = 1;
        }
    }
    public LinkedList(){
        this(null);
    }

    public void add(int index,E e){
        if (index <0 || index >size){
            throw new RuntimeException("非法操作！");
        }
        if (index ==0){
            head = new Node(e,head.next,head);
            tail = head;
        }
        Node preNode = head;
        for (int i = 0; i < index-1; i++) {
           preNode = preNode.next;
        }

        preNode.next = new Node(e,preNode.next,preNode);
        size++;
    }

    public Node findPre(int index){
        if (index <0 || index > size){
            throw new RuntimeException("非法操作！");
        }
        if (index == 0){
            return null;
        }
        Node preNode = head;
        for (int i = 0; i < index-1; i++) {
            preNode = preNode.next;
        }
        return preNode;
    }
    public Node findCur(int index){
        if (index <0 || index > size){
            throw new RuntimeException("非法操作！");
        }
        Node curNode = head;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("linkedlist: head ");
        Node curNode = this.head;
        while (curNode != null){
            sb.append(curNode.e+" --> ");
            curNode = curNode.next;
        }
        sb.append("Null ");
        return sb.toString();
    }
}
