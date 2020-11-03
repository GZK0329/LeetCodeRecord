package com.gzk.leetcode139;

import java.util.LinkedList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {

        String s = "leetcode";

        List<String> wordDict = new LinkedList<>();
        wordDict.add("leet");
        wordDict.add("code");

        Solution ss = new Solution();
        System.out.println(ss.wordBreak(s,wordDict));

    }
}
