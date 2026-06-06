package top.chenqwwq.leetcode.contest.weekly._391._3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/3/31
 **/
public class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        final int n = nums.length;
        if (n < 2) return n;
        long ans = 0;
        int l = 0, r = 1;
        for (; r < n; r++) {
            if (nums[r] == nums[r - 1]) {
                ans += count(r - l);
                l = r;
            }
        }
        return ans + count(r - l);
    }

    Map<Integer, Long> memo = new HashMap<>();

    public long count(int n) {
        return memo.computeIfAbsent(n, m -> {
            long ans = 0;
            for (int i = 1; i <= m; i++) ans += i;
            return ans;
        });
    }
}
