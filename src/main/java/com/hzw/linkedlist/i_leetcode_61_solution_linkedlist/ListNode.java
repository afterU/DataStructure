package com.hzw.linkedlist.i_leetcode_61_solution_linkedlist;

public class ListNode {
    int val;
    ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      ListNode(int[] arr){
          this.val = arr[0];
          ListNode cur = this;
          for (int i = 1; i < arr.length; i++) {
              cur.next = new ListNode(arr[i]);
              cur = cur.next;
          }
      }

    @Override
    public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append("listnode: head ");
          ListNode cur = this;
          while (cur != null){
              sb.append(cur.val+" --> ");
              cur = cur.next;
          }
          sb.append("Null ");
        return sb.toString();
    }
}
