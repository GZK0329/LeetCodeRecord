package com.gzk.leetcode86;

/*
* 86. 分隔链表
给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5
* */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode sign1 = left;
        left.next = null;
        ListNode right = new ListNode(0);
        ListNode sign2 = right;
        right.next = null;

        while(head.next != null){
            if(head.next.val < x){
                left.next = new ListNode(head.next.val);
                left = left.next;
            }else{
                right.next = new ListNode(head.next.val);
                right = right.next;
            }
            head = head.next;
        }
        if(left != null){
            left.next = sign2;
            return sign1;
        }else{
            return right;
        }

    }
}
