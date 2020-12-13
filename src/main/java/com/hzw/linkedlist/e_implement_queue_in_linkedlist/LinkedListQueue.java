package com.hzw.linkedlist.e_implement_queue_in_linkedlist;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

public class LinkedListQueue<E> implements Queue<E> {
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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 链表只有头节点指针，元素入队性能低，这里维护一个尾节点指针，
    // 这样从链表尾添加元素复杂度O(1),但是由于链表有方向性，所以链表尾删除元素复杂度O(n)高，
    // 因此我们只在链表头进行出队（链表实现的队列具有方向性）
    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        //队列为空
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()){
            throw  new RuntimeException("队列为空！");
        }
        Node node = head;
        head = head.next;
        node.next = null;//解除要出队的元素对下一个节点的引用
        if (head == null){//出队后如果后一个元素为空，则tail为空
            tail = null;
        }
        size--;
        return node.e;
    }

    public E getFront() {
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: front ");
        Node cur = head;
        while (cur != null){
            stringBuilder.append(cur.e+"-->");
            cur = cur.next;
        }
        stringBuilder.append(" NULL tail");
        return stringBuilder.toString();
    }
}
