package com.hzw.e_set_map.f_leetcode_349_350_set_map;

import java.util.ArrayList;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/27 2:43 PM
 */
public class LinkedListSet349Solution<E> {
  interface Set<E> {

    public void add(E e);

    public void remove(E e);

    public boolean contains(E e);

    public int getSize();

    public boolean isEmpty();

  }
  class LinkedList<E> {
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

    public E get(int index){
      if (index <0 || index >size){
        throw new RuntimeException("index越界，非法操作");
      }
      Node pre = dummyHead;
      for (int i = 0; i < index; i++) {
        pre = pre.next;
      }
      return pre.next.e;
    }
    public E getFirst(){
      return get(0);
    }
    public E getLast(){
      return get(size);
    }

    public void update(int index,E e){
      if (index <0 || index >size){
        throw new RuntimeException("index越界，非法操作");
      }
      Node pre = dummyHead;
      for (int i = 0; i < index; i++) {
        pre = pre.next;
      }
      pre.next.e = e;
    }
    public boolean contains(E e){
      Node pre = dummyHead;
      for (int i = 0; i < size; i++) {
        pre = pre.next;
        if (pre.e.equals(e)){
          return true;
        }
      }
      return false;
    }

    public E remove(int index){
      if (index <0 || index >size){
        throw new RuntimeException("index越界，非法操作");
      }
      Node pre = dummyHead;
      for (int i = 0; i < index; i++) {
        pre = pre.next;
      }
      Node node = pre.next;
      pre.next = node.next;
      node = null;
      size--;
      return node.e;
    }
    public E removeFirst(){
      return remove(0);
    }
    public E removeLast(){
      return remove(size);
    }

    public void removeElement(E e){

      Node pre = dummyHead;

      while (pre.next != null){
        if (e.equals(pre.next.e)){
          break;
        }
        pre = pre.next;
      }
      if (pre.next != null){
        Node delNode = pre.next;
        pre.next = delNode.next;

        delNode.next = null;
        size--;

      }
    }

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      Node cur = dummyHead;
      while (cur.next != null){
        stringBuilder.append(cur.e).append(" --> ");
        cur = cur.next;
      }
      stringBuilder.append("NULL");
      return stringBuilder.toString();
    }
  }
  class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet(){
      linkedList = new LinkedList<E>();
    }
    public void add(E e) {
      if (!linkedList.contains(e)) {
        linkedList.addFirst(e);
      }
    }

    public void remove(E e) {

      linkedList.removeElement(e);
    }

    public boolean contains(E e) {
      return linkedList.contains(e);
    }

    public int getSize() {
      return linkedList.getSize();
    }

    public boolean isEmpty() {
      return linkedList.isEmpty();
    }
  }

  public int[] intersection(int[] nums1, int[] nums2) {

    LinkedListSet<Integer> bstSet = new LinkedListSet<Integer>();
    for (int i : nums1) {
      bstSet.add(i);
    }

    ArrayList<Integer> li = new ArrayList<Integer>();
    for (int i : nums2) {
      if (bstSet.contains(i)){
        li.add(i);
        bstSet.remove(i);
      }
    }

    int[] result = new int[li.size()];
    for (int i = 0; i < li.size(); i++) {
      result[i] = li.get(i);
    }

    return  result;
  }

  public static void main(String[] args) {
    LinkedListSet349Solution<Integer> integerBSTMap349Solution = new LinkedListSet349Solution<Integer>();

//    nums1 = [4,9,5], nums2 = [9,4,9,8,4]

    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};

    int[] intersection = integerBSTMap349Solution.intersection(nums1, nums2);

    for (int i : intersection) {

      System.out.println(i);
    }
  }
}
