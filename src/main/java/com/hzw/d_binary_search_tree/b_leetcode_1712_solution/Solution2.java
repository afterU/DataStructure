package com.hzw.d_binary_search_tree.b_leetcode_1712_solution;

/**
 * @author huangzhiwei
 * @version 1.0
 * @description
 * @createTime 2020/12/18 11:14 AM
 */
public class Solution2 {

  TreeNode pre = new TreeNode(0);
  TreeNode head = pre;

  public TreeNode convertBiNode(TreeNode root) {



    deal(root);
    return head.right;
  }

  public void deal(TreeNode node){
    if (node==null){
      return;
    }
    deal(node.left);

    pre.right = node;
    node.left = null;
    pre = pre.right;
    deal(node.right);
  }

}
