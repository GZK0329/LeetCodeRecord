package com.gzk.leetcode452;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        //sort 左坐标[x][0] 右坐标[x][1]
        int len = points.length;
        if(len == 0) return 0;
        //排序
         /*
         错误
         Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });*/
        Arrays.sort(points, new Comparator<int[]>(){

            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }

        });
        int sum = 0;
        for(int i = 0; i < len; ++i){
            if(i+1 < len && points[i][1] >= points[i+1][0]){
                sum++;
                i+=1;
            }
            else{
                sum++;
            }

        }
        return sum;
    }
}