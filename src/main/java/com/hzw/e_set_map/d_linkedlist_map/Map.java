package com.hzw.e_set_map.d_linkedlist_map;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/25 4:25 PM
 */
public interface Map<K,V> {

  void add(K key,V value);

  void set(K key,V value);

  V remove(K key);

  V get(K key);

  int getSize();

  boolean contains(K key);

  boolean isEmpty(K key);

}
