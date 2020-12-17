package com.hzw.d_binary_search_tree.c_breadth_traverse_bst;




public class Test {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 4, 2};
        BST<Integer> bst = new BST<Integer>();
        for (int i : arr) {
            bst.add(i);
        }

        bst.preOrder();

        System.out.println("--------------------------------");
        bst.inOrder();
        System.out.println("--------------------------------");
        bst.postOrder();
        System.out.println("--------------------------------");

        bst.levelOrder();

    }
}
