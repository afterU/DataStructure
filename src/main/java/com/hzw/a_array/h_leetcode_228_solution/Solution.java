package com.hzw.a_array.h_leetcode_228_solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description  leetcode的228号题
 * @createTime 2020/12/14 10:00 AM
 */
public class Solution {

  public List<String> summaryRanges(int[] nums) {

    ArrayList<String> list = new ArrayList<String>();
    if (nums == null || nums.length < 1) {
      return list;
    }
    if (nums.length == 1) {
      list.add(String.valueOf(nums[0]));
      return list;
    }

    int order = nums[1] - nums[0] > 0 ? 1 : -1;

    for (int i = 0; i < nums.length; i++) {
      int outer = nums[i];
      for (; i < nums.length - 1; i++) {
        if (nums[i + 1] - nums[i] != order) {
          if (outer == nums[i]) {
            list.add(String.valueOf(outer));
          } else {
            list.add(outer + "->" + nums[i]);
          }
          if (i == nums.length - 2) {
            if (nums[i + 1] - nums[i] == order) {
              list.add(outer + "->" + nums[i + 1]);
            } else {
              list.add(String.valueOf(nums[i + 1]));
            }
          }
          break;
        } else {
          if (i == nums.length - 2) {
            list.add(outer + "->" + nums[i + 1]);
          }
        }

      }

    }
    return  list;
  }



}
