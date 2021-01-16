package com.gzk.leetcodeTest;

public class Solution {
    public int cutCake(){



        return 0;
    }
    public boolean isPingFang(int x){
        //x >= 3       1 + 2
        for(int i = 1; i < x/2; ++i){
            if(i * i == x){
                return true;
            }
        }
        return false;
    }
}
