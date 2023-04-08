package com.example.datastructureandalgorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RecursiveInOrderTraversal {
  List<Integer> inorderTraversal(TreeNode root){
    List<Integer> result = new ArrayList<>();
    dfs(root,result);
    return result;
  }
  public void dfs(TreeNode root,List<Integer> result){
    if(root == null){
      return;
    }
    dfs(root.left,result);
    result.add(root.val);
    dfs(root.right,result);
  }

}
