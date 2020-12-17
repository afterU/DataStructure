package com.hzw.d_binary_search_tree.c_breadth_traverse_bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树的 广度优先遍历（层级遍历），相比于深度优先遍历，在二分搜索树中层级遍历在查找元素方面性能更好
 * 层级遍历借助队列数据结构实现
 */
public class BST<E extends Comparable<E>> {

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

    public BST(){
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
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层级遍历
     */
    public void levelOrder(){
        if (size == 0){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.e);
            if (node.left != null){
                queue.add(node.left);
            }

            if (node.right != null){
                queue.add(node.right);
            }

        }
    }


}
