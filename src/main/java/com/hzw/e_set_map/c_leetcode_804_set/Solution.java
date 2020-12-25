package com.hzw.e_set_map.c_leetcode_804_set;

import com.hzw.e_set_map.c_leetcode_804_set.LinkedListSetSolution.LinkedListSet;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/25 4:08 PM
 */
public class Solution {
  public int uniqueMorseRepresentations(String[] words) {

    if (words == null || words.length <1){
      return 0;
    }
    String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

//    HashSet<String> set = new HashSet<String>();
    TreeSet<String> set = new TreeSet<String>();
    for (String word : words) {
      String code = "";
      for (int i = 0; i <  word.length(); i++) {
        code += codes[word.charAt(i)-'a'];
      }
      set.add(code);
    }

    return set.size();

  }
}
