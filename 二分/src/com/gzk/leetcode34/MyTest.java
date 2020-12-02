package com.gzk.leetcode34;

public class MyTest {
    public static void main(String[] args) {
        int[] nums = { 5,7,7,8,8,10};
        Solution s = new Solution();
        for (int i : s.searchRange(nums, 8)) {
            System.out.println(i);
        }
        return;
    }
}
