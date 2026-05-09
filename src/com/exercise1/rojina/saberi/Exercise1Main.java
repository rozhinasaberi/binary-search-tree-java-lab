/*
 * lab 7 ex 1
 * this is the main file for the bst demo
 * i insert sample values here, print inorder, then test the iterative search
 * main is separate so the tree file keeps only bst logic
 */
package com.exercise1.rojina.saberi;

public class Exercise1Main {
    public static void main(String[] args) {

        // Rojina Saberi
        // 301533334

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.printTree();
        System.out.println();

        System.out.println("Inorder traversal of the BST:");
        bst.displayInorder();

        int[] testValues = {40, 70, 25, 80, 100};

        System.out.println("\nTesting iterative treeSearch:");
        for (int value : testValues) {
            TreeNode<Integer> result = bst.treeSearch(value);

            if (result != null) {
                System.out.println("Value " + value + " found in the tree.");
            } else {
                System.out.println("Value " + value + " not found in the tree.");
            }
        }
    }
}
