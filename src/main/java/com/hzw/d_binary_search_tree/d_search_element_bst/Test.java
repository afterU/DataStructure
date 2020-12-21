package com.hzw.d_binary_search_tree.d_search_element_bst;




public class Test {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 8, 4, 2};
        BST<Integer> bst = new BST<Integer>();
        for (int i : arr) {
            bst.add(i);
        }

        System.out.println(bst.minElement());
        System.out.println(bst.maxElement());
    }
}
