package top.chenqwwq.leetcode.daily._2023._20230703;

import top.chenqwwq.leetcode.common.ListNode;
import top.chenqwwq.leetcode.common.Node;

/**
 * @author 沽酒
 * @since 2023/07/03
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode fake = new ListNode(-1),head = fake;
        int prime = 0;
        while (l1 != null && l2 != null){
            int sum =prime + l1.val + l2.val;
            head.next = new ListNode(sum % 10);
            prime = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        while (l1 != null){
            int sum = prime + l1.val;
            head.next = new ListNode(sum % 10);
            prime = sum/ 10;
            l1 = l1.next;
            head = head.next;
        }
        while (l2!= null){
            int sum = prime + l2.val;
            head.next = new ListNode(sum % 10);
            prime = sum/ 10;
            l2 = l2.next;
            head = head.next;
        }
        if(prime != 0) head.next = new ListNode(prime);

        return reverse(fake.next);
    }

    /**
     * 链表翻转
     */
    private ListNode reverse(ListNode node) {
        ListNode head = null, next = node;
        while (next != null) {
            ListNode nn = next.next;
            next.next = head;
            head = next;
            next = nn;
        }
        return head;
    }
}