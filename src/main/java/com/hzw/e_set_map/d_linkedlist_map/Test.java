package com.hzw.e_set_map.d_linkedlist_map;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/25 5:01 PM
 */
public class Test {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
    LinkedListMap<String, Integer> map = new LinkedListMap<String, Integer>();

    for (int i : arr) {
      map.add(i+"",i);
    }
    map.set("4",100);

    System.out.println(map.remove("5"));

    System.out.println(map);
  }

}
