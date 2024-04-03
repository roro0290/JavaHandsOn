package com.example.dataStructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeNodeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        int[] array = new int[]{14, 6, 2, 1, 3, 5, 7};
        for (int a : array) {
            root.insert(a);
        }
        Assertions.assertTrue(root.contains(3));
        Assertions.assertFalse(root.contains(8));
        System.out.println("print in order");
        root.printInOrder();

        System.out.println("print in preorder");
        root.preOrderTraversal();

        System.out.println("print in postorder");
        root.postOrderTraversal();

        System.out.println("print using breadth first traversal");
        root.breadthFirstSearch(root);
    }

}
