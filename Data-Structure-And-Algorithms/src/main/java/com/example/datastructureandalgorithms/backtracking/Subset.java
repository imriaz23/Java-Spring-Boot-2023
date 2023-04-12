package com.example.datastructureandalgorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
  public void generateSubsets(int index,int []nums, List<Integer> curr,List<List<Integer>> ans){
    System.out.println(curr);
    for(int i = index; i < nums.length; i++){
      curr.add(nums[i]);
      generateSubsets(i + 1,nums,curr,ans);
      curr.remove(curr.size() - 1);
    }
  }
  public static void main(String[] args) {
    Subset s = new Subset();
    int [] nums = {1,2,3};
    List<List<Integer>> ans = new ArrayList<>();
    s.generateSubsets(0,nums,new ArrayList<>(),ans);
//    System.out.println(ans);
  }
}
