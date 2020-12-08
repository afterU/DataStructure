package com.hzw.stacksAndqueue.stack.b_stack_leetcode;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description 使用自定义的动态数组解决
 * @createTime 2020/12/8 4:21 PM
 */
public class Solution2 {

  public boolean isValid(String s) {
     ArrayStack<Character> stack = new ArrayStack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '('|| c=='[' || c== '{'){
        stack.push(c);
      }else{
        if (stack.isEmpty()){
          return false;
        }
        Character pop = stack.pop();
        if (pop == '('&&(c == ']'||c=='}')){
          return false;
        }
        if (pop == '['&&(c == ')'||c=='}')){
          return false;
        }
        if (pop == '{'&&(c == ']'||c==')')){
          return false;
        }
      }
    }
     return stack.isEmpty();
  }
}
