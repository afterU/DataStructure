package com.hzw.c_linkedlist.d_implement_stack_in_linkedlist;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description  Stack栈接口
 * @createTime 2020/12/8 3:42 PM
 */
public interface Stack<E> {

  boolean isEmpty();

  //获取栈中的数据量
  int getSize();
  //入栈
  void push(E e);

  //出栈
  E pop();

  //查看栈顶的元素
  E peek();

}
