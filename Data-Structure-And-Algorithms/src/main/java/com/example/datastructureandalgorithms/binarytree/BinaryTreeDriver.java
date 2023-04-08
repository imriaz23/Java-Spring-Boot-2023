package com.example.datastructureandalgorithms.binarytree;

import java.util.List;

public class BinaryTreeDriver {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.right.left = new TreeNode(7);
    Traversal traversal = new IterativePreOrderTraversal();
    List<Integer> traverse = traversal.traverse(root);
    System.out.println(traverse);

  }
}
