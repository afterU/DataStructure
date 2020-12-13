package com.hzw.linkedlist.a_linkedlist;

import javax.swing.*;

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
    public LinkedList(){
        this(null);
    }

    public void add(int index,E e){
        if (index <0|| index>size){
            throw new RuntimeException("index越界，非法操作");
        }
        if (index == 0){
            addFirst(e);
        }else{
            //遍历找到指定位置index的元素前驱元素
            Node preNode = head;
            for (int i = 0; i < index-1; i++) {
                preNode = preNode.next;
            }

//            Node node = new Node(e);
//            node.next = preNode.next;
//            preNode.next = node;

            preNode.next = new Node(e,preNode.next);
            size++;
        }
    }

    public void addFirst(E e){
        head = new Node(e);
        size++;
    }
    public void addLast(E e){
        add(size,e);
    }
}
