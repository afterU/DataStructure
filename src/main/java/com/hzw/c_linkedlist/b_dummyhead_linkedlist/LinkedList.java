package com.hzw.c_linkedlist.b_dummyhead_linkedlist;

public class LinkedList<E> {
    //内部类Node存储存储各个元素，和指向下一个元素的指针next
    private class Node{
        private E e;
        private Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(){this(null,null);}
        public Node(E e){this(e,null);}
    }

    /**
     * 由于头节点之前没有了节点，所以在添加元素的时候，添加头节点的元素和其他节点的元素逻辑不一致，为了解决这个问题引入虚拟头节点
     */

    //虚拟节点
    private Node dummyHead;
    //记录元素个数
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size=0;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private void add(int index,E e){
        if (index < 0||index > size){
            throw new RuntimeException("index非法！");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
             pre = pre.next;
        }
//        Node node = new Node(e);
//        node.next = pre.next;
//        pre.next = node;
        pre.next = new Node(e,pre.next);
        size++;
    }

    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }
}
