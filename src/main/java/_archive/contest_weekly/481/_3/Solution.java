package top.chenqwwq.leetcode.contest.weekly._481._3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/12/22
 **/
public class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;
        Map<Integer, Integer> total = new HashMap<>();
        for (int x : nums) {
            total.merge(x, 1, Integer::sum);
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        int k = 0;
        int mx = 0;
        for (int i = 0; i < n; i++) {
            int x = forbidden[i];
            int c = total.merge(x, 1, Integer::sum);
            if (c > n) {
                return -1;
            }
            if (x == nums[i]) {
                k++;
                c = cnt.merge(x, 1, Integer::sum);
                mx = Math.max(mx, c);
            }
        }

        return Math.max((k + 1) / 2, mx);
    }
}