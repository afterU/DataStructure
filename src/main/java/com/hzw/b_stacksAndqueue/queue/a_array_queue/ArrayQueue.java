package com.hzw.b_stacksAndqueue.queue.a_array_queue;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/8 4:41 PM
 */
public class ArrayQueue<E> implements Queue<E> {

  private Array<E> array;

  public ArrayQueue(){
    array = new Array<E>();
  }
  public ArrayQueue(int capacity){
    array = new Array<E>(capacity);
  }


  public int getCapacity() {
    return array.getCapacity();
  }

  public boolean isEmpty() {
    return array.isEmpty();
  }

  //入队，均摊复杂度分析，时间复杂度为O(1)
  public void enqueue(E e) {

    array.addLast(e);
  }

  //出队，时间复杂度为O(n)
  public E dequeue() {
    return array.removeFirst();
  }

  //查看队首，时间复杂度为O(1)
  public E getFront() {
    return array.getFirst();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Queue: front[");
    for (int i = 0; i < array.getSize(); i++) {
       builder.append(array.get(i));
       if (i != array.getSize()-1){
         builder.append(",");
       }
    }
    builder.append("] tail");
    return builder.toString();
  }
}
