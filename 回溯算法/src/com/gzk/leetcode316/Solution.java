package com.gzk.leetcode316;

import java.util.Arrays;
import java.util.Stack;
/*
* 316. 去除重复字母
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同

示例 1：

输入：s = "bcabc"
输出："abc"

示例 2：

输入：s = "cbacdcbc"
输出："acdb"

* */
class Solution {
    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        //Map<Character, Integer> map = new HashMap<>();
        int[] base = new int[26];
        Arrays.fill(base, 0);
        for(int j = 0; j < s.length(); ++j){
            base[s.charAt(j) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); ++i){
            while(!stack.isEmpty() && stack.peek() > s.charAt(i) && base[stack.peek() - 'a'] > 1){
                base[stack.peek() - 'a']--;
                stack.pop();
                //stack.push(s.charAt(i));
            }
            stack.push(s.charAt(i));
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
