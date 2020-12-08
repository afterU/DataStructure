package com.hzw.array.b_add_element_array;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description  向自定义数组中添加元素
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

  // 向数组中指定的位置添加元素
  public void add(int index,int element){
    //判断数组是否满了
    if (size >= data.length){
      throw new RuntimeException("数组已经满了");
    }

    if (index <0 || index>size){
      throw new RuntimeException("添加元素失败，必须index>=0或者index<=size");
    }

    //添加之前将index>=index的元素向后移动
    for (int i = size; i <= index; i--) {
      data[i++] = data[i];
    }

    data[index] = element;
  }

  //向数组中第一个位置添加元素
  public void addFirst(int element){
    add(0,element);
  }

  //向数组中最后一个位置添加元素
  public void addLast(int element){
    add(size,element);
  }
}
