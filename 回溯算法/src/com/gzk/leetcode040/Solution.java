package com.gzk.leetcode040;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.sort;



/*给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 */

public class Solution {

    List<List<Integer>> listRes = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0) {
            return listRes;
        }
        Arrays.sort(candidates);
        dfs(candidates, target,0, path, listRes);

        return listRes;
    }

    void dfs(int[] candidates, int target,int begin, LinkedList<Integer> path, List<List<Integer>> listRes){
        int N = candidates.length;
        //结果
        if(target == 0){
            listRes.add(new LinkedList<Integer>(path));
        }

        //循环选择列表
        for(int i = begin; i < N; i++){

            if(target - candidates[i] < 0){
                //这条路已经不通了  candidates经过排序  后面备选项都比candidate[i] 大
                break;
            }
            if(i > begin && candidates[i] == candidates[i-1]){
                //剪枝 因为不能用重复的
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i+1, path, listRes);
            path.removeLast();
        }

    }

}
