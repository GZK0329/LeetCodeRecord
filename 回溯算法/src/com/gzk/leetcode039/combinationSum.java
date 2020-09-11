package com.gzk.leetcode039;

import com.sun.org.glassfish.gmbal.ParameterNames;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*给定一个无重复元素的数组 candidates 和一个目标数 target,
找出 candidates 中所有可以使数字和为 target 的组合.

candidates 中的数字可以无限制重复被选取.

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
*/
public class combinationSum {
    LinkedList<Integer> list = new LinkedList<>();
    List<List<Integer>> listRes = new LinkedList<>();
    //int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates,target,list, listRes,0);
        return listRes;
    }

    public void dfs(int[] candidates, int target, LinkedList<Integer> list, List<List<Integer>> listRes,int idx){
        int N = candidates.length;
        //递归 出口
        //加到队列里边
            if(idx == N){ return;}
            if(target == 0) {listRes.add(new LinkedList<Integer>(list));return;}

            dfs(candidates, target, list, listRes,idx+1);
            if(target - candidates[idx] >= 0 ){
                list.add(candidates[idx]);
                dfs(candidates,target-candidates[idx],list,listRes,idx);
                list.removeLast();
            }


    }

}
