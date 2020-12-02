package com.gzk.leetcode767;

import java.util.Comparator;
import java.util.PriorityQueue;

/*767. 重构字符串
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""
注意:

S 只包含小写字母并且长度在[1, 500]区间内。*/
public  class Solution {
    public  String reorganizeString(String S) {
        if (S.length() < 2) return S;
        int[] count = new int[26];
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            count[c - 'a']++;
            maxCount = Math.max(maxCount, count[c - 'a']);
        }

        if(maxCount > (S.length() + 1) / 2){
            return "";
        }
        PriorityQueue<Character> priQue = new PriorityQueue<>(new Comparator<Character>(){
            public int compare(Character char1, Character char2){

                //重写规则 后减前为大顶堆
                return count[char2 - 'a'] - count[char1 - 'a'];
            }
        });

        for(char c = 'a'; c <= 'z'; ++c){
            if(count[c -'a'] > 0) {
                priQue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(priQue.size() > 1)
        {
            char ch1 = priQue.poll();
            char ch2 = priQue.poll();
            sb.append(ch1);
            sb.append(ch2);
            count[ch1 - 'a']--;
            count[ch2 - 'a']--;
            if(count[ch1 - 'a'] > 0){
                priQue.offer(ch1);
            }
            if(count[ch2 - 'a'] > 0){
                priQue.offer(ch2);
            }
        }
        //奇数情况
        if(priQue.size() > 0){
            sb.append(priQue.poll());
        }

        return sb.toString();

    }
}
