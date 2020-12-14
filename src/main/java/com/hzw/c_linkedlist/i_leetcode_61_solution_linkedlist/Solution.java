package com.hzw.c_linkedlist.i_leetcode_61_solution_linkedlist;

public class Solution {
    /**
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null|| head.next==null){
            return head;
        }
        int length = 0;
        ListNode curNode = head;
        ListNode lastNode = null;
        while(curNode != null){
            length++;
            lastNode = curNode;
            curNode = curNode.next;
        }
        k = k%length;

        //首尾相接
        lastNode.next = head;

        //在head偏移k的位置断开

        ListNode newNode = head;
        for (int i = 0; i < length-k-1; i++) {
            newNode = newNode.next;

        }
       ListNode ret = newNode.next;
        newNode.next = null;

        return ret;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(rotateRight(listNode, 2));
    }
}
