package com.gzk.leetcode947;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for(int[] stone : stones){
            uf.union(10001 + stone[0], stone[1]);
        }
        return stones.length - uf.count();

    }
    private class UnionFind{
        //map代表连通关系 int1与int2相连接 即在同一行或者同一列
        private Map<Integer,Integer> parents;
        private int count;
        public UnionFind(){
            this.parents = new HashMap<>();
            this.count = 0;
        }
        public int find(int x){
            //初始化工作
            if(!parents.containsKey(x)) {parents.put(x, x);count++;}
            if(parents.get(x) != x){
                parents.put(x, find(parents.get(x)));
            }
            return parents.get(x);

        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;
            else{
                parents.put(rootX, rootY);
                count--;
            }
        }
        public int count(){
            return this.count;
        }
    }
}