package com.hzw.a_array.a_create_array;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description  自定义数组
 * @createTime 2020/12/2 4:27 PM
 */
public class Array {

  private int[] data;

  private int size;

  // 创建容量为capacity的数组
  public Array(int capacity){
    data = new int[capacity];
    size =0;
  }

  // 默认容量capacity为10
  public Array(){
    this(10);
  }
  // 获取数组的容量
  public int getCapacity(){
    return  data.length;
  }
  // 获取数组的大小
  public int getSize(){
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }
}
