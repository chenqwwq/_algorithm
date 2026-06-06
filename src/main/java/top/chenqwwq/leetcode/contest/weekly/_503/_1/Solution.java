package top.chenqwwq.leetcode.contest.weekly._503._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/5/24
 **/
public class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        final int n = nums.length;
        final List<Integer> ans = new ArrayList<>();
        int cur = 0, cnt = 0;
        for (int num : nums) {
            if (cur != num) {
                cur = num;
                cnt = 1;
                ans.add(num);
            } else if (++cnt <= k) {
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}