package com.gzk.leetcode面0402;
/*
* 面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5
*
* */

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int l, int r){
        if(l > r){
            return null;
        }
        //因为有序 所以直接取中间
        int mid =l + (r - l)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, l, mid-1);
        node.right = helper(nums, mid + 1, r);
        return node;
    }
}
