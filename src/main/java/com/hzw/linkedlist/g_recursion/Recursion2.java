package com.hzw.linkedlist.g_recursion;

public class Recursion2 {

    public static ListNode removeElement(ListNode head,int val){
        if ( head == null){
            return head;
        }
        ListNode ret = removeElement(head.next,val);
        if (head.val == val){

            return  ret;
        }else{
            //这里需要，想明白，这里是删除==val节点的关键
            head.next = ret;
            return head;
        }
    }

    public static ListNode removeElement2(ListNode head,int val){
        if (head == null){
            return  head;
        }
        head.next = removeElement2(head.next,val);
        return head.val == val ? head.next:head;
    }

    public static void main(String[] args) {
        int[] arr = {6,6,6,1,2,3,6,4,5,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode listNode1 = removeElement(listNode, 6);
        System.out.println(listNode1);
    }
}
