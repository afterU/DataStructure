package com.hzw.c_linkedlist.g_recursion;

public class Recursion1 {
    public static int sum(int[] arr,int l){
        if (l == arr.length){
            return 0;
        }
        return arr[l]+sum(arr,++l);
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};

        System.out.println(sum(num, 4));
        System.out.println(sum(num, 3));
    }
}
