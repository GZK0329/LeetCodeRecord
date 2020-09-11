package com.gzk.leetcode216;
/*216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。*/


import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> listRes = new LinkedList<>();
    //List<Integer> candidate = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n == 0) {
            return listRes;
        }
        dfs(k, n, 1,path,listRes);
        return listRes;

    }
    void dfs(int nums, int target,int begin,LinkedList<Integer> path, List<List<Integer>> listRes){
        int sum = 0;
        if(target == 0 && nums == sum ){
             listRes.add(new LinkedList<Integer>(path));
        }

        for(int i = begin; i < 10; i++){
            if(target - i < 0){
                break;
            }
            path.add(i);sum++;
            dfs(nums-1,target-i,i + 1,path, listRes);
            path.removeLast();sum--;
        }
    }
}
