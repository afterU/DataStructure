package com.hzw.d_binary_search_tree.b_leetcode_1712_solution;


import apple.laf.JRSUIUtils.Tree;
import javax.swing.RootPaneContainer;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/15 9:47 AM
 */
public class Solution {

  /**
    *输入： [4,2,5,1,3,null,6,0]
   * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
   * @description   面试题 17.12. BiNode
    * @author huangzhiwei
    * @createTime 2020/12/15 9:47 AM
    * @version 1.0
    */

  static TreeNode pre = new TreeNode(0);
  static TreeNode head = null;

  public static  TreeNode convertBiNode(TreeNode root) {

    //构建虚拟头节点


    deal(root);
    return head.right;
  }

  public static void deal(TreeNode node){
    if (node==null){
      return;
    }
    deal(node.left);

    if (head == null){

      head = pre;

    }
    pre.right = node;
    node.left = null;
    pre = pre.right;
    deal(node.right);
  }

  static  TreeNode root;
  public static void main(String[] args) {

    int[] arr = {4,2,5,1,3,6,0};


    for (int i : arr) {
      add(i);
    }

    preOrder();

    convertBiNode(root);


  }

  public static void add(int val){
    root = add(root,val);
  }

  private static TreeNode add(TreeNode node, int val) {
    if (node == null){
      return  new TreeNode(val);
    }
    if (node.val > val){
      node.left = add(node.left,val);
    }else if (node.val < val){
      node.right = add(node.right,val);
    }
    return node;
  }

  public static void preOrder(){
    preOrder(root);
  }

  private static void preOrder(TreeNode root) {
    if (root.left != null){
      preOrder(root.left);
    }

    System.out.println(root.val);
    if (root.right != null){
      preOrder(root.right);
    }

  }



}
