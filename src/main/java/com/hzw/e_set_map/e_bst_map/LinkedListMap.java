package com.hzw.e_set_map.e_bst_map;


/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/25 4:28 PM
 */
public class LinkedListMap<K,V> implements Map<K,V> {
  class Node{
    K key;
    V value;
    Node next;

    Node(K key,V value,Node next){
      this.key = key;
      this.value = value;
      this.next = next;
    };
    Node(){this(null,null,null);}
    Node(K key,V value){
      this(key,value,null);
    };

    @Override
    public String toString() {
      return this.key+" : "+this.value;
    }
  }

  private Node dummyHead;
  private int size;

  LinkedListMap(){
    dummyHead = new Node();
    size = 0;
  }

  private Node get(Node node,K key){
    if (node == null || node.key.equals(key)){
      return node;
    }
    return get(node.next,key);
  }

  public void add(K key, V value) {
    //是否包含
    Node node = get(dummyHead.next, key);
    if (node != null){
      return;
    }
    dummyHead.next = new Node(key,value,dummyHead.next);
    size++;
  }

  public void set(K key, V value) {
    Node node = get(dummyHead.next, key);
    if (node == null){
      throw new RuntimeException("key 元素不存在！");
    }
    node.value = value;
  }

  public V remove(K key) {
   //找到key的前驱
    Node pre = dummyHead;
    while (pre.next != null){
      if (pre.next.key.equals(key)){
        break;
      }
      pre = pre.next;
    }
    if (pre.next != null){
      Node delNode = pre.next;
      pre.next = delNode.next;
      size--;
      return delNode.value;
    }
    return null;
  }

  public V get(K key) {
    Node node = get(dummyHead.next, key);
    return node== null?null:node.value;
  }

  public int getSize() {
    return size;
  }

  public boolean contains(K key) {
    Node node = get(dummyHead.next, key);
    return node== null?false:true;
  }

  public boolean isEmpty(K key) {
    return size==0;
  }
}
