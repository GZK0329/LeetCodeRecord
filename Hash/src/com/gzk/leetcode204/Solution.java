package com.gzk.leetcode204;

import java.util.Arrays;

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
public class Solution {
    //方法一 枚举法 略

    //方法二 埃氏筛


    public int countPrimes(int n) {
        //质数则设为1，合数则设为0
        int[] isPrime = new int[n];
        Arrays.fill(isPrime,1);
        int sum = 0;


        for(int i = 2; i < n; ++i){
                int k = 0;
                if(isPrime[i] == 1){
                    sum++;
                    /*if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrime[j] = 0;
                        }
                    }*/
                    //先转换再乘 先乘再转换会溢出
                    while( ((long)i * (long)(i + k)) < n){
                        //long j = i * (i + k);
                        //System.out.println(j);
                        isPrime[i * (i + k)] = 0;
                        k++;
                    }
                }
        }

        return sum;
    }
}


