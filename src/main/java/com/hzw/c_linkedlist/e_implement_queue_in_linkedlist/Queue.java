package com.hzw.c_linkedlist.e_implement_queue_in_linkedlist;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description 队列，
 * @createTime 2020/12/8 4:32 PM
 */
public interface Queue<E> {

  int getSize();
  boolean isEmpty();

  //入队
  void enqueue(E e);
  //出队
  E dequeue();
  //查看队首
  E getFront();

}
