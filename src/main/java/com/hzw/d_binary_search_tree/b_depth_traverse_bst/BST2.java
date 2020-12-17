package com.hzw.d_binary_search_tree.b_depth_traverse_bst;

import java.util.Stack;

/**
 * 二分搜索树的 深度度优先遍历：前序/中序/后序 遍历，深度优先遍历即进入到树结构的最深即叶子节点向根节点进行遍历
 * 使用非递归的方式实现，前序遍历，其实递归就是借助系统栈完成的调用，这里使用非递归的方式遍历也是借助栈这种数据结构来做
 */
public class BST2<E extends Comparable<E>> {

    private class Node{
        private E e;
        private Node left;
        private Node right;
        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    private int size;

    public BST2(){
        root = null;
        size = 0;
    }

    //向二分搜索树中添加元素
    public void add(E e){
        if (root == null){
            root = new Node(e);
            size++;
            return;
        }

        add(root,e);
    }
    //递归添加元素
    private void add(Node node, E e) {
        //递归的出口
        if (node == null ){
            node = new Node(e);
            size++;
        }else if (node.left == null&& node.e.compareTo(e)>0){
            node.left = new Node(e);
            size++;
        }else if (node.right == null&&node.e.compareTo(e)<0){
            node.right = new Node(e);
            size++;
        }

        //递归方法的进一步拆解
        if (node.e != null&&node.e.compareTo(e)<0){
            add(node.right,e);
        }else if (node.e != null&&node.e.compareTo(e)>0){
            add(node.left,e);
        }else{
            //node.e.compareTo(e)==0;  //不需要处理
        }
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node node, E e) {
        if (node == null){
            return false;
        }
        if (node.e.compareTo(e)==0){
            return  true;
        }else if (node.e.compareTo(e)<0){
            return contains(node.right,e);
        }else{
            return contains(node.left,e);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        bstToString(root,0,sb);

        return sb.toString();
    }

    private void bstToString(Node node, int depth, StringBuilder sb) {
        if (node == null){
            sb.append(generateDepthString(depth)+"Null"+"\n");
            return;
        }
        sb.append(generateDepthString(depth)+node.e+"\n");
        bstToString(node.left,depth+1,sb);
        bstToString(node.right,depth+1,sb);
    }

    private String generateDepthString(int depth) {
        String ret = "";
        for (int i = 0; i < depth; i++) {
           ret += "--";

        }
        return ret;
    }


    /**
     * 前序遍历，
     */
    public void preOrder(){
        if (size==0){
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            //由于栈先进后出，这里先将右子树压入栈，保证右子树后于左子树出栈
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }

        }

    }





}
