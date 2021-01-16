package com.gzk.leetcode103;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = new ArrayList<>();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        res = solution.zigzagLevelOrder(root);
        for(List<Integer> l : res){
            for(int i  : l){
                System.out.println(i);
            }
            System.out.println("/n");
        }
    }
}
