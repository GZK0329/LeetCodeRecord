package com.gzk.leetcode659未完成;

import java.util.*;
/*
* 659. 分割数组为连续子序列
给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。

如果可以完成上述分割，则返回 true ；否则，返回 false 。

示例 1：

输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 :
1, 2, 3
3, 4, 5

示例 2：

输入: [1,2,3,3,4,4,5,5]
输出: True
解释:
你可以分割出这样两个连续子序列 :
1, 2, 3, 4, 5
3, 4, 5

示例 3：

输入: [1,2,3,4,4,5]
输出: False
*
* */
class Solution {
    public boolean isPossible(int[] nums) {

        int n = nums.length;
        if(n < 3) return false;
        ArrayList[] res = new ArrayList[n];
        Arrays.fill(res,new ArrayList<>(0));
        PriorityQueue<Integer> prique = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer int1, Integer int2){
                return int2 - int1;
            }
        });

        int flag = 0;
        for(int i = 0; i < n; ++i){
            //依次放入数组队列中  不一样了就把标志清零
            if(!prique.isEmpty() && prique.peek() == nums[i]){
                flag++;
                //res[flag].add(nums[i]);
            }
            if(!prique.isEmpty() && nums[i] != prique.peek()){
                flag = 0;
            }
            prique.add(nums[i]);
            ArrayList re = res[flag];
            re.add(nums[i]);
        }
        //迭代 保证顺序和长度大于3
        int pre = -1;
        int cur = -1;
        for(ArrayList a : res){
            if(a.size() < 3) return false;
            if(a.isEmpty()){break;}
            Iterator iterator = a.iterator();
            pre = Integer.MAX_VALUE;cur = Integer.MAX_VALUE;
            while(iterator.hasNext()){
                cur = (int)iterator.next();
                if(pre == Integer.MAX_VALUE){
                    pre = cur;continue;
                }
                if(cur - pre != 1){return false;}
                pre = cur;
            }
        }
        return true;
    }
}
