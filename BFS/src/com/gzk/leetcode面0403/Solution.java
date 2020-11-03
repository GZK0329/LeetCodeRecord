package com.gzk.leetcode面0403;

import java.util.*;

class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {

        Deque<TreeNode> dq = new LinkedList<>();

        List<ListNode> res = new ArrayList<>();

        ListNode dummy = new ListNode(0);

        if(tree == null) return new ListNode[0];
        dq.addFirst(tree);

        while(!dq.isEmpty()){
            int size = dq.size();
            ListNode curr = dummy;
            while(size-- > 0){
                TreeNode node = dq.getFirst();
                curr.next = new ListNode(node.val);
                curr = curr.next;
                dq.removeFirst();
                if(node.left != null){
                    dq.addLast(node.left);
                }
                if(node.right != null){
                    dq.addLast(node.right);
                }
            }
            res.add(dummy.next);
            dummy.next = null;

        }
        return res.toArray(new ListNode[]{});
    }
}
