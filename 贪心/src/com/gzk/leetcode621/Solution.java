package com.gzk.leetcode621;

import java.util.*;

/*
* 621. 任务调度器
给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。

然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的 最短时间 。

示例 1：

输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
示例 2：

输入：tasks = ["A","A","A","B","B","B"], n = 0
输出：6
解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
诸如此类
示例 3：

输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
输出：16
解释：一种可能的解决方案是：
     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
* */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //Map map = new HashMap()
        Map<Character, Integer> map = new HashMap<>();

        for(char c : tasks){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int size = map.size();
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> resCount = new ArrayList<>();

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            //下次冷却完成的时间
            nextValid.add(1);
            //剩余次数
            resCount.add(entry.getValue());
        }

        //起始时间
        int time = 1;
        int len = tasks.length;
        int max = 0;
        int maxIndex = -1;

        //一共len个任务完成就结束
        while(len > 0){
            max = 0;
            maxIndex = -1;
            //一共size种任务
            for(int i = 0; i < size; ++i){
                //冷却完成时间小于等于现在时间且剩余次数不为0
                if(nextValid.get(i) <= time && resCount.get(i) > 0){
                    //找到剩余次数最多的
                    if(max < resCount.get(i)){
                        max = resCount.get(i);
                        maxIndex = i;
                    }
                }
            }
            //没找到合适的 那就直接待机
            if(max == 0){
                time++;
                continue;
            }
            //更新冷却时间和剩余次数
            nextValid.set(maxIndex, time + n + 1);
            resCount.set(maxIndex, resCount.get(maxIndex) - 1);
            time++;
            len--;
        }
        //time从1到2 完成了第一个任务
        return time - 1;
    }
}