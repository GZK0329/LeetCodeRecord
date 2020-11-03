package com.gzk.leetcode047;

import java.util.*;
/*
* 47. 全排列 II
* 给定一个可包含重复数字的序列，返回所有不重复的全排列。
* */

class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    //HashMap<Integer, Integer> candidate = new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, path, res);
        return res;
    }

    public void dfs(int[] nums, LinkedList<Integer> path, List<List<Integer>> res){

        if(path.size() == nums.length){
            res.add(new LinkedList<Integer>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            path.add(nums[i]);
            dfs(nums,path,res);
            path.removeLast();

        }
    }
}
