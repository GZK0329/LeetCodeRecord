package com.gzk.leetcode349;
/*
* 349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]


说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
*
* */


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i :
                nums1) {
            set1.add(i);
        }
        for (int j :
                nums2) {
            set2.add(j);
        }

        Set<Integer> ans =  new HashSet<>();

        if(set1.size() > set2.size()){
            for(int i : set2){
                if(set1.contains(i)){
                    ans.add(i);
                }
            }
        }
        else{
            for(int j : set1){
                if(set2.contains(j)){
                    ans.add(j);
                }
            }
        }
        int[] res = new int[ans.size()];
        int begin = 0;
        for(int i : ans){
            res[begin++] = i;
        }
        return res;

    }
}