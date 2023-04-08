package com.example.datastructureandalgorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal implements Traversal {

  @Override
  public List<Integer> traverse(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }

  public void dfs(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    result.add(root.val);
    dfs(root.left, result);
    dfs(root.right, result);
  }
}
