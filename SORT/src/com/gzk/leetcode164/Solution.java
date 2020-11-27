package com.gzk.leetcode164;

import java.util.Arrays;

/*164. 最大间距
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

如果数组元素个数小于 2，则返回 0。

示例 1:

输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
示例 2:

输入: [10]
输出: 0
解释: 数组元素个数小于 2，因此返回 0。
说明:

你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。

*/
class Solution {
    public static int maximumGap(int[] nums) {
        int n = nums.length;
        if(n <= 1 ) return 0;
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i){
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        if((max - min) == 0) return 0;
        int interval = (int)Math.ceil((double)(max - min) / (n - 1));

        int[] bucketMax = new int[n-1];
        int[] bucketMin = new int[n-1];
        Arrays.fill(bucketMax, -1);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);

        for(int i = 0; i < n; ++i){
            if(nums[i] == min || nums[i] == max) continue;
            int ID = (nums[i] - min) / interval;
            bucketMax[ID] = Math.max(nums[i], bucketMax[ID]);
            bucketMin[ID] = Math.min(nums[i], bucketMin[ID]);

        }
        int maxGap = 0;
        int preMax = min;
        for(int i = 0; i  < n - 1; ++i){
            if(bucketMax[i] == -1) continue;
            maxGap = Math.max(bucketMin[i] - preMax, maxGap);
            preMax = bucketMax[i];
        }
        maxGap = Math.max(max - preMax, maxGap);
        return maxGap;
    }
}
