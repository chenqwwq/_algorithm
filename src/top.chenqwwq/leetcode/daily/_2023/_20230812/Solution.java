package top.chenqwwq.leetcode.daily._2023._20230812;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2023/8/12
 **/
public class Solution {

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode fake = new ListNode(-1), head = fake;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                head.next = n1;
                n1 = n1.next;
            } else {
                head.next = n2;
                n2 = n2.next;
            }
            head = head.next;
        }
        while (n1 != null){
            head.next = n1;
            n1 = n1.next;
            head = head.next;
        }
        while (n2 != null){
            head.next = n2;
            n2 = n2.next;
            head = head.next;
        }
        return fake.next;
    }

    public ListNode merge(ListNode[] nodes, int l, int r) {
        if (l == r) return nodes[l];
        System.out.printf("l:%d,r:%d\n", l, r);
        if (l + 1 == r) return merge(nodes[l], nodes[r]);
        int mid = (l + r) / 2;
        return merge(merge(nodes, l, mid), merge(nodes, mid + 1, r));
    }

    public ListNode mergeKLists(ListNode[] nodes) {
        final int n = nodes.length;
        if(n == 0) return null;
        if(n == 1) return nodes[0];
        return merge(nodes, 0, n - 1);
    }

}