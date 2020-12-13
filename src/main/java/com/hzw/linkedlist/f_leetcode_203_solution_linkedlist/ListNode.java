package com.hzw.linkedlist.f_leetcode_203_solution_linkedlist;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x){
        this.val = x;
    }

    public ListNode(int[] arr){
        if (arr == null || arr.length < 1){
            throw new RuntimeException("数组为空！");
        }
        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("listnode:head ");
        ListNode curNode = this;
        while (curNode != null){
            sb.append(curNode.val+" --> ");
            curNode = curNode.next;
        }
        sb.append("Null ");
        return sb.toString();
    }
}
