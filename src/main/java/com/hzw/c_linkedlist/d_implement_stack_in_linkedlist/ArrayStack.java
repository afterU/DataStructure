package com.hzw.c_linkedlist.d_implement_stack_in_linkedlist;

import com.hzw.b_stacksAndqueue.stack.a_array_stack.Array;


/**
 * @author huangzhiwei
 * @version 1.0
 * @description  基于动态数组实现的栈
 * @createTime 2020/12/8 3:45 PM
 */
public class ArrayStack<E> implements Stack<E> {

  private Array<E> array;

  public ArrayStack(){
    array = new Array<E>();
  }

  //时间复杂度O(1)
  public ArrayStack(int capacity){
    array = new Array<E>(capacity);
  }

  public boolean isEmpty() {
    return array.isEmpty();
  }

  public int getSize() {
    return array.getSize();
  }

  // 基于均摊复杂度分析，时间复杂度是O(1)
  public void push(E e) {

    array.addLast(e);
  }
  // 基于均摊复杂度分析，时间复杂度是O(1)
  public E pop() {
    return array.removeLast();
  }

  //时间复杂度是O(1)
  public E peek() {
    return array.getLast();
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("stack: [");
    for (int i = 0; i < array.getSize(); i++) {
       builder.append(array.get(i));
       if (i != array.getSize()-1){
         builder.append(",");
       }
    }
    builder.append("] top");
    return builder.toString();
  }
}
