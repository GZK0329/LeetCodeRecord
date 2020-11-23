package com.gzk.leetcode剑55;

//解二 后序遍历 DFS

public class Solution2 {
    public int maxDepth(TreeNode root) {
    if(root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
