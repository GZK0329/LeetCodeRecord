package com.gzk.leetcode763;


import java.util.ArrayList;
import java.util.List;

/*
* 763. 划分字母区间
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。

示例 1：

输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

提示：
S的长度在[1, 500]之间
S只包含小写字母 'a' 到 'z'
* */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int m = S.length();
        int right = -1;
        for(int i = 0;  i < m; i++){
            char temp = S.charAt(i);
            for(int j = i+1; j < m; j++){
                if(temp == S.charAt(j)){
                    right = j;
                }
                list.add(right-i);
            }
            i = right+1;
        }
        return list;
    }
}
