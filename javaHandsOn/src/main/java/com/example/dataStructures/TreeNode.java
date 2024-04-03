package com.example.dataStructures;

import java.util.*;

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
    Preorder traversal is a depth-first search algorithm for a binary search tree that first traverses the root,
    then the left subtree, and then the right subtree. Its primary use is to create a copy of the tree
    time complexity = O(n) - all nodes are visited
    space complexity = O(h) where h = height of the tree
        worst case: h = N => skewed tree
        best case: h = log(N) => well- balanced tree
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
    Postorder traversal is a depth-first search algorithm for a binary search tree that
    1. first traverses the left subtree,
    2. then the right subtree,
    3. and then the root.
    Its primary use is deleting the tree.
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

    /*
    Traverse the tree level by level, by using a queue
     */
    public void breadthFirstSearch(TreeNode root){
        if(root == null)
            System.out.println("none");

        // Create a queue to store nodes at each level
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.data);

            if(poll.left != null){
                queue.add(poll.left);
            }

            if(poll.right != null){
                queue.add(poll.right);
            }

            Stack<Integer> stack = new Stack<>();
            List<String> list = new ArrayList<>();
            list.add("");
        }
        Arrays.sort(new int[]{1,2,3,4});

    }

}
