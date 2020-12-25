package com.hzw.e_set_map.e_bst_map;

import java.awt.image.renderable.RenderableImage;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/25 5:12 PM
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

  class Node{
    K key;
    V value;
    Node left,right;

    Node(K key,V value){
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }
    Node(){
      this(null,null);
    }
  }

  private Node root;
  private int size;
  public BSTMap(){
    this.root = null;
    size = 0;
  }
  public void add(K key, V value) {
    root = add(root,key,value);

  }

  private Node add(Node node, K key, V value) {
    if (node == null){
      size++;
      return  new Node(key,value);
    }
    if (node.key.compareTo(key)>0){
      node.left = add(node.left,key,value);
    }else if (node.key.compareTo(key)>0){
      node.right = add(node.right,key,value);
    }
    return node;
  }
  private Node getNode(Node node,K key){
    if (node == null|| node.key.compareTo(key)==0){
      return node;
    }
    if (node.key.compareTo(key)>0){
      return getNode(node.left,key);
    }else {
      return getNode(node.right,key);
    }

  }

  public void set(K key, V value) {

    Node node = getNode(root, key);
    if (node == null){
      throw new RuntimeException("key 不存在！");
    }
    node.value = value;
  }

  public V remove(K key) {

    Node node = getNode(root, key);
    if (node != null){
      remove(root,key);
    }
    return node==null?null:node.value;
  }

  private Node remove(Node node,K key){
    if (node ==null){
      return  null;
    }else if(node.key.compareTo(key)>0){
      node.left = remove(node.left,key);
      return node;
    }else if(node.key.compareTo(key)<0){
      node.right = remove(node.right,key);
      return node;
    }else{
      //=
      if (node.left==null){
        size--;
        return node.right;
      }else if (node.right == null){
        size--;
        return node.left;
      }else{
        Node min = minNode(node.right);
        Node nod = removeMin(node.right);
        min.right = nod;
        min.left = node.left;

        return min;
      }
    }
  }

  private Node minNode(Node node){
    if (node==null){
      return null;
    }
    if (node.left == null){
      return node;
    }else{
      return minNode(node.left);
    }
  }
  private Node removeMin(Node node){
    if (node.left == null){
      Node right = node.right;
      node.right=null;
      size--;
      return right;
    }
    node.left = removeMin(node.left);
    return node;
  }

  public V get(K key) {
    Node node = getNode(root, key);
    return node== null?null:node.value;
  }

  public int getSize() {
    return size;
  }

  public boolean contains(K key) {
    Node node = getNode(root, key);
    return node==null?false:true;
  }

  public boolean isEmpty(K key) {
    return size==0;
  }
}
