package com.hzw.e_set_map.e_bst_map;


import com.hzw.e_set_map.b_linkedlistset.FileOperation;
import java.util.ArrayList;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/25 5:01 PM
 */
public class Test {

  public static void main(String[] args) {
//    int[] arr = {1,2,3,4,5,6};
//
//    BSTMap<String, Integer> map = new BSTMap<String, Integer>();
//
//    for (int i : arr) {
//      map.add(i+"",i);
//    }
//    map.set("4",100);
//
//    System.out.println(map.remove("5"));
//
//    System.out.println(map);

    testMapTime();
  }

  public static double testMap(Map<String,Integer> map,String file){
    file = ClassLoader.getSystemResource(file).getPath();
    long start = System.nanoTime();
    ArrayList<String> list = new ArrayList<String>();
    if (FileOperation.readFile(file, list)) {
      System.out.println("傲慢与偏见，总单词数：" + list.size());

      for (String s : list) {
        if (map.contains(s)){
          map.set(s,map.get(s)+1);
        }else{
          map.add(s,1);
        }
      }
      System.out.println("傲慢与偏见，不同单词数：" + map.getSize());
      System.out.println("Frequency of PRIDE: " + map.get("pride"));
      System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
    }

    long end = System.nanoTime();

    return (end-start)/1000000000.0;

  }

  public static void testMapTime(){
    LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<String, Integer>();
    double time = testMap(linkedListMap, "pride-and-prejudice.txt");

    System.out.println("linkedlistmap耗时："+time);

    BSTMap<String, Integer> bstMap = new BSTMap<String, Integer>();
    double time1 = testMap(bstMap, "pride-and-prejudice.txt");

    System.out.println("bstmap耗时："+time1);
  }

}
