package com.example.datastructureandalgorithms.binarytree;

import java.util.List;

public class BinaryTreeDriver {
  public static void main(String[] args) {
    int [] nums = {1,2,3,4,5,6,7,8,9,10};
    BuildBinaryTree buildBinaryTree = new BuildBinaryTree();
    TreeNode root = buildBinaryTree.build(nums);
    RecursiveInOrderTraversal recursiveInOrderTraversal = new RecursiveInOrderTraversal();
//    List<Integer> result = recursiveInOrderTraversal.inorderTraversal(root);
    IterativeInOrderTraversal iterativeInOrderTraversal = new IterativeInOrderTraversal();
    List<Integer> result = new IterativeInOrderTraversal().traverse(root);
    System.out.println(result);
  }
}
