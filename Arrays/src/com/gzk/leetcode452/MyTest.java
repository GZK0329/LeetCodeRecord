package com.gzk.leetcode452;

import java.util.Arrays;
import java.util.Comparator;

public class MyTest {
    public static void main(String[] args) {
        int[][]  points = {{10,16},{2,8},{1,6},{7,12}};

        Solution sol = new Solution();
        System.out.println(sol.findMinArrowShots(points));
        return;
    }
}
