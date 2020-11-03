package com.gzk.leetcode349;

public class MyTest {
    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1,3};
        int[] nums2 = {2,2,3};
        Solution ss = new Solution();
        for(int i : ss.intersection(nums1,nums2)){
            System.out.println(i + " ");
        }

    }
}
