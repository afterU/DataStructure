package com.hzw.c_linkedlist.f_leetcode_203_solution_linkedlist;

/**
 * 使用头节点的链表解决leetcode的203问题
 */
public class Solution1 {
    /*从链表head中删除元素val，然后返回链表
     */
    public static ListNode removeElement(ListNode head,int val){

        //如果头节点元素为val，循环删除
        while (head != null&&head.val == val){
//            ListNode node = head;
//            head = node.next;
//            node.next = null;
            head = head.next;
        }
        //非头节点元素为val
        if(head != null){
            ListNode checkNode = head;
            while (checkNode.next != null){
                if (checkNode.next.val == val){
//                    ListNode delNode = checkNode.next;
//                    checkNode.next = delNode.next;
//                    delNode.next = null;
                    checkNode.next = checkNode.next.next;
                }else{
                    checkNode = checkNode.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,6,4,5,6};
//        ListNode listNode = new ListNode(arr);
//        System.out.println(listNode);
//        ListNode listNode1 = removeElement(listNode, 6);
//        System.out.println(listNode1);
        int[] arr = {6,6,6,1,2,3,6,4,5,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode listNode1 = removeElement(listNode, 6);
        System.out.println(listNode1);
    }
}
