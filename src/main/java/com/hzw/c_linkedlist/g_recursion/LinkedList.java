package com.hzw.c_linkedlist.g_recursion;

public class LinkedList<E> {

    //内部类Node存储存储各个元素，和指向下一个元素的指针next
    private class Node{
        private E e;
        private Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(){this(null,null);}
        public Node(E e){this(e,null);}
    }
    //链表中存储头节点指针
    private Node head;
    //记录元素个数
    private int size;

    public LinkedList(E e){
        if (e == null){
            head = null;
            size = 0;
        }else{
            head = new Node(e,null);
            size = 1;
        }
    }
    public LinkedList(E[] e){
        if (e == null || e.length <1){
            throw new RuntimeException("非法操作！");
        }

        Node curNode = new Node(e[0]);
        this.head = curNode;
        for (int i = 1; i < e.length; i++) {

            curNode.next   = new Node(e[i]);
            curNode = curNode.next;
        }
        size = e.length;
    }
    public LinkedList(){

        head = null;
        size =0;
    }
    public void add(int index,E e){
        if (index <0|| index>size){
            throw new RuntimeException("index越界，非法操作");
        }
        head = add(head,index,e);
        size++;

    }
    public Node add(Node head,int index,E e){
        if (index == 0){
            head = new Node(e,head);
            return head;
        }
        Node addNode = add(head.next,index-1,e);
        head.next = addNode;
        return head;
    }





    public void addFirst(E e){
        head = new Node(e);
        size++;
    }
    public void addLast(E e){
        add(size,e);
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append("linkedlist: head ");
        Node cur = head;
        while (cur != null){
            sb.append(cur.e+" --> ");
            cur =cur.next;
        }
        sb.append(" Null");
        return sb.toString();
    }
}
