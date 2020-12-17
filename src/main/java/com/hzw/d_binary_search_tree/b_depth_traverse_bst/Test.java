package com.hzw.d_binary_search_tree.b_depth_traverse_bst;



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
        BST2<Integer> bst2 = new BST2<Integer>();

        for (int i : arr) {
            bst2.add(i);
        }
        bst2.preOrder();

    }
}
