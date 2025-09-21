package top.chenqwwq.leetcode.contest.biweek._84._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/8/7
 **/
public class Solution {
    public long countBadPairs(int[] nums) {
        final int n = nums.length;
        Map<Integer, Integer> diff2Cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            diff2Cnt.put(diff, diff2Cnt.getOrDefault(diff, 0) + 1);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            int old = diff2Cnt.put(diff, diff2Cnt.get(diff) - 1);
            ans += n - i - old;
        }
        return ans;
    }
}