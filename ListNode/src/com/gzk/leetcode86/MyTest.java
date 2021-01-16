package com.gzk.leetcode86;

public class MyTest {
    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode list = new ListNode(1);

        //[1,4,3,2,5,2]
        list.next = new ListNode(4);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(2);
        sol.partition(list,3);


    }
}
