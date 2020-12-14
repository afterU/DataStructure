package com.hzw.b_stacksAndqueue.stack.b_stack_leetcode;

import java.util.Stack;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description  使用java的util包中的Stack解决问题
 * @createTime 2020/12/8 4:08 PM
 */
public class Solution1 {

  public boolean isValid(String s){
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ('(' == c||'[' == c||'{'==c){
        stack.push(c);
      }else{
        if (stack.isEmpty()){
          return  false;
        }
        Character peek = stack.pop();
        if (peek == '('&&(c == ']'||c=='}')){
          return false;
        }
        if (peek == '['&&(c == ')'||c=='}')){
          return false;
        }
        if (peek == '{'&&(c == ')'||c==']')){
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
