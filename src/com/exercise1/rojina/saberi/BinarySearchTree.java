/*
 * lab 7 ex 1
 * this file is the binary search tree implementation
 * tree search is iterative here, so i move current left or right until i stop
 * bst property is used because smaller values stay left and bigger values stay right
 */
package com.exercise1.rojina.saberi;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    // tree search
    public TreeNode<T> treeSearch(T key) {
        if (key == null) {
            return null;
        }

        TreeNode<T> current = root;

        while (current != null) {
            int comparison = key.compareTo(current.getData());

            if (comparison == 0) {
                return current; // found
            } else if (comparison < 0) {
                current = current.getLeft(); // go left
            } else {
                current = current.getRight(); // go right
            }
        }

        return null; // not found
    }

    //------- easier test
    public void insert(T value) {
        if (value == null) {
            return;
        }

        TreeNode<T> newNode = new TreeNode<>(value);

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode<T> current = root;
        TreeNode<T> parent = null;

        while (current != null) {
            parent = current;

            int comparison = value.compareTo(current.getData());

            if (comparison < 0) {
                current = current.getLeft();
            } else if (comparison > 0) {
                current = current.getRight();
            } else {
                return; // duplicate value, do not insert again
            }
        }

        if (value.compareTo(parent.getData()) < 0) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }
    //-------

    //to display tree
    public void inorder(TreeNode<T> node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.print(node.getData() + " ");
            inorder(node.getRight());               // inorder traversal
        }
    }

    public void displayInorder() {
        inorder(root);
        System.out.println();
    }

    public void printTree() {
        System.out.println("tree shape:");
        printTree(root, 0);
    }

    private void printTree(TreeNode<T> node, int level) {
        if (node == null) {
            return;
        }

        printTree(node.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(node.getData());

        printTree(node.getLeft(), level + 1);
    }
}
