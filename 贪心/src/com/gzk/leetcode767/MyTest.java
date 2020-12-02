package com.gzk.leetcode767;

public class MyTest {
    public static void main(String[] args) {
        String s = "abb";
        /*System.out.println(Solution.reorganizeString(s));*/
        Solution ss = new Solution();
        s = ss.reorganizeString(s);
        System.out.printf(s);
        return;
    }
}
