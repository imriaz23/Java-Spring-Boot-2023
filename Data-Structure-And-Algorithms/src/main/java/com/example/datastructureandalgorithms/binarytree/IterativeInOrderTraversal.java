package com.example.datastructureandalgorithms.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrderTraversal {
  public List<Integer> traverse(TreeNode root){
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while(!stack.empty() || root != null){
      while(root != null){
        stack.add(root);
        root = root.left;
      }
      if(!stack.isEmpty()){
        root = stack.pop();
        ans.add(root.val);
        root = root.right;
      }
    }
    return ans;
  }
}
