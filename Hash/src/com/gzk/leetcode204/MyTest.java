package com.gzk.leetcode204;

import java.net.Socket;

/*
* 204. 计数质数
统计所有小于非负整数 n 的质数的数量。

示例 1：

输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
示例 2：

输入：n = 0
输出：0
示例 3：

输入：n = 1
输出：0

* */
public class MyTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPrimes(499979));
        return;
    }
}
