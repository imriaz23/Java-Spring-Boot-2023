package com.example.datastructureandalgorithms.binarytree;

import java.util.Stack;

public class HasPathSum {
  public boolean solve(TreeNode root, int targetSum){
    Stack<TreeNode> stack = new Stack<>();
    while(!stack.isEmpty() || root != null){
      while(root != null){
        int temp = root.val;
        root.val = targetSum - temp;
        targetSum -= temp;
        stack.add(root);
        root = root.left;
      }
      if(!stack.isEmpty()){
        root = stack.pop();
        if(root.left == null && root.right == null){
          if(root.val == 0){
            return true;
          }
        }
      }
    }
    return false;
  }
}
