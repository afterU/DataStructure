package com.hzw.e_set_map.b_linkedlistset;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
//        String pa = ClassLoader.getSystemResource("pride-and-prejudice.txt").getPath();
//        ArrayList<String> list = new ArrayList<String>();
//        if (FileOperation.readFile(pa,list)) {
//            System.out.println("傲慢与偏见，总单词数："+list.size());
//            LinkedListSet<String> stringLinkedListSet = new LinkedListSet<String>();
//            for (String s : list) {
//                stringLinkedListSet.add(s);
//            }
//            System.out.println("傲慢与偏见，不同单词数："+stringLinkedListSet.getSize());
//        }

      testTimeSet();

    }

    public static double testSet(Set<String> set,String file) {
      String pa = ClassLoader.getSystemResource(file).getPath();
      long start = System.nanoTime();
      ArrayList<String> list = new ArrayList<String>();
      if (FileOperation.readFile(pa, list)) {
        System.out.println("傲慢与偏见，总单词数：" + list.size());

        for (String s : list) {
          set.add(s);
        }
        System.out.println("傲慢与偏见，不同单词数：" + set.getSize());
      }
      long end = System.nanoTime();

      return (end-start)/1000000000.0;
    }

    public static void testTimeSet(){
      LinkedListSet<String> linkedListSet = new LinkedListSet<String>();
      double time = testSet(linkedListSet, "pride-and-prejudice.txt");
      System.out.println("linkedlistset耗时"+time);

      BSTSet<String> bstSet = new BSTSet<String>();
      double time1 = testSet(bstSet, "pride-and-prejudice.txt");
      System.out.println("bstset耗时"+time1);
    }
}
