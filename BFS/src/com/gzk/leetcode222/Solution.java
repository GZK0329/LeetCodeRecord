package com.gzk.leetcode222;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int countNodes(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        if(null == root){
            return 0;
        }
        dq.addLast(root);
        int sum = 0;
        while(!dq.isEmpty()){
            int size = dq.size();
            while(size-- > 0){
                if(!dq.isEmpty()){
                    TreeNode node = dq.getFirst();
                    sum++;
                    dq.removeFirst();
                    if(node.left != null) dq.addLast(node.left);
                    if(node.right != null) dq.addLast(node.right);
                }
            }
        }
        return sum;
    }
}
