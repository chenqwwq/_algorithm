package top.chenqwwq.leetcode.contest.weekly._321._3;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2022/11/27
 **/
public class Solution {

    public ListNode removeNodes(ListNode head) {
        int[] stack = new int[(int) 1e5 + 10];
        int p = 0;
        ListNode node = head;
        // 单调栈遍历找出循环递减的数组
        while (node != null) {
            while (p != 0 && stack[p - 1] < node.val) p--;
            stack[p++] = node.val;
            node = node.next;
        }

        // 根据数组重建链表
        ListNode fake = new ListNode(-1),cur = fake;
        for(int i = 0;i < p && head != null;i++){
            while (head != null && head.val != stack[i]){
                head = head.next;
            }
            if(head != null){
                cur.next = head;
                cur = cur.next;
                head = head.next;
            }
        }
        return fake.next;
    }
}