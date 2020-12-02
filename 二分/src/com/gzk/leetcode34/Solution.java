package com.gzk.leetcode34;
/*
* 34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？


示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]


提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109
* */
class Solution {
    public  int[] searchRange(int[] nums, int target) {
        //二分查找

        int len = nums.length;
        if(len == 0) return new int[]{-1,-1};
        int left = 0;
        int right = len - 1;
        int flag = -1;
        int mid = left +  (right -left) / 2;
        while(left <= right){
            mid = left +  (right -left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
                //mid = left +  (right -left) / 2;
            }
            if(nums[mid] > target){
                right = mid - 1;

            }
            if(nums[mid] == target){
                flag = 1;
                break;
            }

        }
        int[] res = new int[2];

        int i = -1;
        int j = -1;
        if(flag == 1){
            if(mid == len - 1){
                j = mid;
                if(mid - 1 > 0 && nums[mid - 1] == target){
                    i = mid - 1;
                }
                while(mid - 1 > 0 && nums[mid - 1] == target){
                    i--;
                }
                res[0] = i;
                res[1] = mid;
                //res = {i, mid};
            }
            if(mid == 0){
                i = mid;
                if( mid + 1 < len && nums[mid + 1] == target){
                    j = mid + 1;
                }
                while(j + 1 < len && nums[j + 1] == target){
                    j++;
                }
                res[0] = mid;
                res[1] = j;
                //res = {mid ,j};
            }
            if(mid > 0 && mid < len){
                j = mid;
                if(mid + 1 < len && nums[mid + 1] == target){
                    j = mid + 1;
                }
                while(j + 1 < len && nums[j + 1] == target ){
                    j++;
                }
                i = mid;
                if(mid - 1 > 0 && nums[mid - 1] == target){
                    i = mid -1;
                    while(i - 1 > 0 && nums[i - 1] == target){
                        i--;
                    }
                }
                res[0] = i;
                res[1] = j;
                //res = {i,j};
            }
        }
        else if(flag == -1){
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }
}
