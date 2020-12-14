package com.hzw.c_linkedlist.d_implement_stack_in_linkedlist;

import java.util.Random;

public class Test {

    public static double testStack(Stack<Integer> stack,int count){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
             stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long end = System.nanoTime();
        return (end - start)/ 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 10000000;
        ArrayStack<Integer> integerArrayStack = new ArrayStack<Integer>();
        double testTime1 = testStack(integerArrayStack, count);
        System.out.println("ArrayStack: "+testTime1);

        LinkedListStack<Integer> integerLinkedListStack = new LinkedListStack<Integer>();
        double testTime2 = testStack(integerArrayStack, count);
        System.out.println("LinkedListStack: "+testTime2);
    }
}
