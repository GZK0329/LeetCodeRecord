package com.gzk.leetcode面0403;

import java.util.LinkedList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        TreeNode tree =  new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.left.left = new TreeNode(8);
        tree.left.right =  new TreeNode(5);
        tree.right.right = new TreeNode(7);

        Solution ss = new Solution();
        ListNode dummy = new ListNode(0);
        for (ListNode listNode : ss.listOfDepth(tree)) {

            System.out.println(listNode.val);
        }

    }
}
