package top.chenqwwq.leetcode.contest.weekly._472._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2025/10/20
 **/
public class Solution {
    public int missingMultiple(int[] nums, int k) {
        final Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!s.contains(k * i)) {
                return k * i;
            }
        }
        return -1;
    }
}