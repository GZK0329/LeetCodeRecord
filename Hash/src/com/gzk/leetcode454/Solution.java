package com.gzk.leetcode454;

import java.util.HashMap;


/*
454. 四数相加 II
给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

*/
class Solution {
    public static  int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        //HashMap<Integer, Integer> map2 = new HashMap<>();
        int lenA = A.length;
        int lenB = B.length;
        int lenC = C.length;
        int lenD = D.length;

        for(int i = 0; i < lenA; ++i){
            for(int j = 0; j < lenB; ++j){
                map1.put(A[i] + B[j], map1.getOrDefault(A[i] + B[j],0) + 1);
            }
        }
        int sum = 0;
        for(int i = 0; i < lenC; ++i){
            for(int j = 0; j < lenD; ++j){
                int reverseInt = -(C[i] + D[j]);
                //Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
                //while(iterator.hasNext()){
                //    Map.Entry<Integer, Integer> entry = iterator.next();
                //    if(entry.getKey() + reverseInt == 0) sum++;
                //}
                if(map1.containsKey(reverseInt)) {
                    sum += map1.get(reverseInt);
                };
            }
        }
        return sum;
    }
}
