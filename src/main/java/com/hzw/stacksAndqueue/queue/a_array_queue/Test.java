package com.hzw.stacksAndqueue.queue.a_array_queue;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/8 4:48 PM
 */
public class Test {

  public static void main(String[] args) {
    ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
    for (int i = 0; i < 20; i++) {
     queue.enqueue(i);
      System.out.println(queue);
      if (i%3==2){
        System.out.println("出队："+queue.dequeue());
      }

    }
  }

}
