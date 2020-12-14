package com.hzw.c_linkedlist.g_recursion;

public class Test {

    public static void main(String[] args) {

        Integer[] e = new Integer[]{1,2,3,4,5};
        LinkedList<Integer> lin = new LinkedList<Integer>((Integer[]) e);

        System.out.println(lin);

        lin.add(2,100);
        System.out.println(lin);


    }
}
