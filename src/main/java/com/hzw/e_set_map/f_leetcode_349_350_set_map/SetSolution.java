package com.hzw.e_set_map.f_leetcode_349_350_set_map;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/27 3:06 PM
 */
public class SetSolution {
  public int[] intersection(int[] nums1, int[] nums2) {

    TreeSet<Integer> bstSet = new TreeSet<Integer>();
    for (int i : nums1) {
      bstSet.add(i);
    }

    ArrayList<Integer> li = new ArrayList<Integer>();
    for (int i : nums2) {
      if (bstSet.contains(i)){
        li.add(i);
        bstSet.remove(i);
      }
    }

    int[] result = new int[li.size()];
    for (int i = 0; i < li.size(); i++) {
      result[i] = li.get(i);
    }

    return  result;
  }
  public static void main(String[] args) {
    SetSolution setSolution = new SetSolution();

//    nums1 = [4,9,5], nums2 = [9,4,9,8,4]

    int[] nums1 = {4,9,5};
    int[] nums2 = {9,4,9,8,4};

    int[] intersection = setSolution.intersection(nums1, nums2);

    for (int i : intersection) {

      System.out.println(i);
    }
  }

}
