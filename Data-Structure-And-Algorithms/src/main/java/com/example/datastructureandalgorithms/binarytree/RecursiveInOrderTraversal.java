package com.example.datastructureandalgorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RecursiveInOrderTraversal implements Traversal {

  public void dfs(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    dfs(root.left, result);
    result.add(root.val);
    dfs(root.right, result);
  }

  @Override
  public List<Integer> traverse(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    dfs(root, result);
    return result;
  }
}
