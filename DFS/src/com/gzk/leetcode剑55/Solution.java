package com.gzk.leetcode剑55;

import java.util.Deque;
import java.util.LinkedList;
/*
*剑指 Offer 55 - I. 二叉树的深度
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
* */
//解一 层次遍历 BFS
class Solution {
    public int maxDepth(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();

        if(root == null){
            return 0;
        }
        dq.addLast(root);
        int depth = 0;
        while(!dq.isEmpty()){
            int size = dq.size();
            while(size-- > 0){
                TreeNode node = dq.getFirst();

                if(node.left !=  null){
                    dq.addLast(node.left);
                }
                if(node.right != null){
                    dq.addLast(node.right);
                }
                dq.removeFirst();
                if(size == 0){
                    depth++;
                }
            }

        }
        return depth;
    }
}
