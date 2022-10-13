package top.chenqwwq.leetcode.daily._20221012;

import top.chenqwwq.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * my request id : 07102022/10294433
 *
 * @author chenqwwq
 * @date 2022/10/12
 **/
public class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int cnt = 0, ans = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                if (++cnt == 1) ans++;
            } else cnt = 0;
            head = head.next;
        }
        return ans;
    }
}