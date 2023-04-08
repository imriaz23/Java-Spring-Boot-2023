package com.example.datastructureandalgorithms.binarytree;

public class BuildBinaryTree {
  public TreeNode build(int[] nums) {
    int n = nums.length;
    return build(nums, 0, n - 1);
  }

  public TreeNode build(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    int mid = left + (right - left);
    TreeNode root = new TreeNode(nums[mid]);
    TreeNode leftSubtree = build(nums, left, mid - 1);
    TreeNode rightSubtree = build(nums, mid + 1, right);
    root.left = leftSubtree;
    root.right = rightSubtree;
    return root;
  }
}
