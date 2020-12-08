package com.hzw.stacksAndqueue.queue.b_loop_queue;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description  循环队列
 * @createTime 2020/12/8 5:00 PM
 */
public class LoopQueue<E> implements Queue<E>{

  // front == tail 则队列为空
  // (tail+1)%data.length==front 则队列满
  // 循环队列需要浪费一个数组空间

  private E[] data;
  private int front; //指向队首的位置
  private int tail; //指向队尾的下一个位置
  private int size;



  public LoopQueue(int capacity){
    data = (E[])new Object[capacity+1];
    front = 0;
    tail = 0;
    size = 0;
  }
  public LoopQueue(){
    this(10);
  }

  public int getCapacity() {
    return data.length-1;
  }

  public boolean isEmpty() {
    return front==tail;
  }

  //入队  均摊复杂度，时间复杂度为O(1)
  public void enqueue(E e) {

    //判断队列是否满了，如果满了，需要扩容
    if ((tail+1)%data.length==front){
      resize(getCapacity()*2);
    }

    data[tail] = e;
    tail = (tail+1)%data.length;
    size++;

  }

  private void resize(int capacity) {

    E[] newData = (E[])new Object[capacity+1];
    for (int i = 0; i < size; i++) {
      newData[i] = data[(front+i)%data.length];
    }
    data = newData;
    front = 0;
    tail = size;

  }

  //出队
  public E dequeue() {

    if (isEmpty()){
      throw new RuntimeException("队列为空！");
    }

    E e = data[front];
    data[front] = null;
    if (size == getCapacity()/4&& getCapacity()/2 != 0){
      resize(getCapacity()/2);
    }
    front = (front+1)%data.length;
    size--;

    return e;
  }

  public E getFront() {
    if (isEmpty()){
      throw new RuntimeException("队列为空！");
    }
    return data[front];
  }
}
