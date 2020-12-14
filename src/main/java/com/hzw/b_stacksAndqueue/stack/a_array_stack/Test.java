package com.hzw.b_stacksAndqueue.stack.a_array_stack;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/8 3:59 PM
 */
public class Test {

  public static void main(String[] args) {
    ArrayStack<Integer> stack = new ArrayStack<Integer>(20);

    for (int i = 0; i < 20; i++) {
      stack.push(i);
      if (i%3 == 2){
        System.out.println("出栈："+stack.pop());
      }
      System.out.println(stack.toString());
    }
  }
}
