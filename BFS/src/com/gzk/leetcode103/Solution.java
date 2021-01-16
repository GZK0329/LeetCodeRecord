package com.gzk.leetcode103;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> dq = new LinkedList<>();
        if(root != null){
            dq.addLast(root);
        }

        int flag = 0;
        while(!dq.isEmpty()){
            int size = dq.size();
            while(size-- > 0){
                //TreeNode node = new TreeNode(dq.removeFirst().val);
                TreeNode node = dq.removeFirst();
                cur.add(node.val);

                //右侧开始
                if(flag == 1){
                    if(node.left != null){
                        dq.addFirst(node.left);
                    }
                    if(node.right != null){
                        dq.addFirst(node.right);
                    }
                    flag = 0;
                }

                //左侧开始
                if(flag == 0){
                    if(node.left != null){
                        dq.addLast(node.left);
                    }
                    if(node.right != null){
                        dq.addLast(node.right);
                    }
                    flag = 1;
                }
            }
            res.add(cur);
            cur = new ArrayList<Integer>();
        }
        return res;
    }
}