package com.example.dataStructures;

/*
Each node has 3 properties:
1. Value
2. Left child
3. Right child
When we instantiate a node, we pass a value to it
Left and right child will be null because when we create a node, it will not have any children. Only data
 */
public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    // initialise a node with data. When we create a node, left and right will be empty
    public TreeNode(int data) {
        this.data = data;
    }

    /*
        start at the root node,
        if smaller -> look at left node
        if bigger -> look at right node
        if that node is empty, we can create a new node and place it there
        if it is not empty, then do an insert on it
    */
    public void insert(int value) {

        if (value <= data) {
            if (left == null) {
                left = new TreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new TreeNode(value);
            } else {
                right.insert(value);
            }
        }

    }

    public boolean contains(int value) {

        if (data == value) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }

    }

    /*
    To print out the values in order
    left -> root -> right
     */
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data); // prints the root / current node
        if (right != null) {
            right.printInOrder();
        }
    }

    /*
    root -> left -> right
     */
    public void preOrderTraversal() {
        System.out.println(data);

        if (left != null) {
            left.preOrderTraversal();
        }

        if (right != null) {
            right.preOrderTraversal();
        }
    }

    /*
    left -> right -> root
    Preorder traversal is a depth-first search algorithm for a binary search tree that first traverses the root,
    then the left subtree, and then the right subtree. Its primary use is to create a copy of the tree
     */
    public void postOrderTraversal() {
        if (left != null) {
            left.postOrderTraversal();
        }
        if (right != null) {
            right.postOrderTraversal();
        }
        System.out.println(data);
    }

}
