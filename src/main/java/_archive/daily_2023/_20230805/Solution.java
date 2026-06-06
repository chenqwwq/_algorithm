package top.chenqwwq.leetcode.daily._2023._20230805;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2023/8/5
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode fake = new ListNode(-1),node = fake;
        while (n1 != null && n2 != null){
            if(n1.val > n2.val){
                node.next = n2;
                n2 = n2.next;
                node = node.next;
            }else{
                node.next = n1;
                n1 = n1.next;
                node =node.next;
            }
        }
        while (n1 != null){
            node.next = n1;
            n1 = n1.next;
            node = node.next;
        }
        while (n2 != null){
            node.next = n2;
            n2 = n2.next;
            node = node.next;
        }
        return fake.next;
    }
}