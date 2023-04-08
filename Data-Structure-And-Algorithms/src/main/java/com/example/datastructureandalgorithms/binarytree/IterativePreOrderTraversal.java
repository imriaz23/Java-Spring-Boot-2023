package com.example.datastructureandalgorithms.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderTraversal implements Traversal{
  @Override
  public List<Integer> traverse(TreeNode root) {
    List<Integer> result= new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while(root != null || !stack.isEmpty()){
      while(root != null){
        result.add(root.val);
        stack.add(root);
        root = root.left;
      }
      if(!stack.isEmpty()){
        root = stack.pop();
        root = root.right;
      }
    }
    return result;
  }
}
