package com.hzw.a_array.e_general_array;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/2 5:21 PM
 */
public class Test {

  public static void main(String[] args) {
    Student student = new Student(10, "1");
    Student student1 = new Student(20, "2");

    Array<Student> studentArray = new Array<Student>();

    studentArray.add(0,student);

    System.out.println(studentArray);
  }

}
