package com.hzw.a_array.c_query_update_array;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description  查询或者更新数组中的元素
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

  // 查询index的元素
  public int get(int index){
    if (index < 0 || index > size){
      throw new RuntimeException("查询的index不存在元素");
    }
    return data[index];
  }
  // 更新index的元素
  public void set(int index,int element){
    if (index < 0 || index > size){
      throw new RuntimeException("查询的index不存在元素");
    }
    data[index] = element;
  }

  @Override
  public String toString(){

    StringBuilder res = new StringBuilder();
    res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
    res.append('[');
    for(int i = 0 ; i < size ; i ++){
      res.append(data[i]);
      if(i != size - 1)
        res.append(", ");
    }
    res.append(']');
    return res.toString();
  }

}
