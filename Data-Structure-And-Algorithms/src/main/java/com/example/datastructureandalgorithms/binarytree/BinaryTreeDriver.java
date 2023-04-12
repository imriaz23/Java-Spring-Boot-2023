package com.example.datastructureandalgorithms.binarytree;

import com.sun.tools.javac.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BinaryTreeDriver {
  public static void main(String[] args) {
    BinaryTreeDriver binaryTreeDriver = new BinaryTreeDriver();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(1);
//    root.left.left = new TreeNode(11);
//    root.left.left.left = new TreeNode(7);
    root.left.right = new TreeNode(3);

    String temp = " " + (char)(1 + 'a');
    System.out.println(temp);
  }
  public int rob(TreeNode root) {
    return Math.max(alternateSum(root),alternateSum(root.left) + alternateSum(root.right));
  }
  public int alternateSum(TreeNode root){
    if(root == null){
      return 0;
    }
    int val = root.val;
    int left = 0;
    if(root.left != null){
      left = alternateSum(root.left.left) + alternateSum(root.left.right);
    }
    int right = 0;
    if(root.right != null){
      right = alternateSum(root.right.right) + alternateSum(root.right.left);
    }
    return root.val + left + right;
  }
}
