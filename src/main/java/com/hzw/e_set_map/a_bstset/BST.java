package com.hzw.e_set_map.a_bstset;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树中删除元素
 * 分三种情况，1。要删除的是叶子节点，直接将该节点删除即可
 *          2. 要删除的节点，只有左节点或者只有右节点，只需要用左节点或者右节点替换该节点即可
 *          3. 要删除的节点，即左节点又有右节点，用左节点的前驱（左子树的最大）或者右节点的后继（右子树的最小）替换该节点即可
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

    public int getSize(){
        return size;
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

    //查找二分搜索树中最小的元素
    public E minElement(){
        if (size == 0){
            throw new RuntimeException("二分搜索树为空");
        }
        return minNode(root).e;
    }

    private Node minNode(Node node) {
        if (node.left == null){
            return node;
        }else{
             return minNode(node.left);
        }
    }
    //查找二分搜索树中最大的元素
    public E maxElement(){
        if (size == 0){
            throw new RuntimeException("二分搜索树为空");
        }
        return maxNode(root).e;
    }

    private Node maxNode(Node node) {
        if (node.right == null){
            return node;
        }else{
            return maxNode(node.right);
        }
    }

    //删除最小元素所在节点，并返回最小元素
    public E removeMinElement(){
        E ret = minElement();
        root = removeMinNode(root);
        return ret;
    }

    private Node removeMinNode(Node node) {
        //要删除的节点没有子节点（即没有右节点）
        if (node.left == null){
            size--;
            return node.right;
        }

        node.left = removeMinNode(node.left);

        return node;
    }

    //删除二分索搜树中的最大的元素，并返回该元素
    public E removeMaxElement(){
        E ret = maxElement();
        root = removeMaxNode(root);
        return ret;
    }

    private Node removeMaxNode(Node node) {
        if (node.right == null){
            size--;
            return node.left;
        }

        node.right = removeMaxNode(node.right);
        return node;
    }

    public void removeElement(E e){
        root = removeElement(root,e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null){
            return null;
        }else if (node.e.compareTo(e)>0){
            node.left =  removeElement(node.left,e);
            return  node;
        }else if (node.e.compareTo(e)<0){
            node.right =  removeElement(node.right,e);
            return  node;
        }else{ //node.e == e
            //如果左节点不存在
            if (node.left == null){
                size--;
                return node.right;
            }
            if (node.right == null){
                size--;
                return node.left;
            }
            //如果左右子节点都有，用左节点的前驱，后者右节点的后继替换该节点都可以,这里选用右节点的后继
            Node houji = minNode(node.right);
            houji.right = removeMinNode(houji);

            houji.left = node.left;
            return houji;

        }
    }


}
