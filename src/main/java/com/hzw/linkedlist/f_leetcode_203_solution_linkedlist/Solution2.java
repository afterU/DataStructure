package com.hzw.linkedlist.f_leetcode_203_solution_linkedlist;

public class Solution2 {
    /**
     * 使用虚拟头节点 删除链表中的元素
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElement(ListNode head,int val){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        if (dummyNode.next == null){
            return  null;
        }
        ListNode checkNode = dummyNode;
        while(checkNode.next != null){
            if (checkNode.next.val == val){
                ListNode delNode = checkNode.next;
                checkNode.next = delNode.next;
                delNode.next = null;
            }else{
                checkNode = checkNode.next;
            }
        }
        return dummyNode.next;

    }

    /**
     * leetcode的剑指offer 22
     * @param head
     * @param k
     * @return  遍历统计链表长度length，然后遍历length-k即为所求
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null){
            return head;
        }
        int length = 0;
        ListNode curNode =head;
        while (curNode != null){
            length++;
            curNode = curNode.next;
        }
        ListNode ret = head;
        for (int i = 0; i < length-k; i++) {
            ret = ret.next;

        }
        return ret;
    }
    /*
        快慢指针，定义两个指针
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        //链表长度未知，定义俩个指针 指针first先向前进k-1，然后first，two同时前进，当前进到没有元素，这是two指向的为所求
        ListNode first,two;
        first = head;
        two = head;
        for (int i = 0; i < k-1; i++) {
            first = first.next;
        }
        while (first.next != null){
            first = first.next;
            two = two.next;
        }
        return two;

    }

    /**
     *  快慢指针，定义一个指针
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd3(ListNode head, int k) {
        ListNode first = head;
        while (first != null){
            first = first.next;
            if (k==0){
                head = head.next;
            }else{
                k--;
            }
        }
        return head;

    }



    public static void main(String[] args) {
                int[] arr = {1,2,3,6,4,5,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode listNode1 = removeElement(listNode, 6);
        System.out.println(listNode1);

        System.out.println(getKthFromEnd(listNode, 2));

//        int[] arr = {6,6,6,1,2,3,6,4,5,6};
//        ListNode listNode = new ListNode(arr);
//        System.out.println(listNode);
//        ListNode listNode1 = removeElement(listNode, 6);
//        System.out.println(listNode1);
    }
}
