package com.hzw.linkedlist.e_implement_queue_in_linkedlist;

import java.util.Random;

public class Test {
    public static double testQueue(Queue<Integer> queue,int count){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();
        return (end - start)/ 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 100000;
        double test1 = testQueue(new ArrayQueue<Integer>(), count);
        System.out.println("ArrayQueue: "+test1);
        double test2 = testQueue(new LoopQueue<Integer>(), count);
        System.out.println("LoopQueue:"+test2);
        double test3 = testQueue(new LinkedListQueue<Integer>(), count);
        System.out.println("LinkedListQueue:"+test3);
    }
}
