package top.chenqwwq.leetcode.contest.weekly._472._2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2025/10/20
 **/
public class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        int ans = 0;
        // 外层枚举几点
        for (int i = 0; i < n; i++) {
            Set<Integer> even = new HashSet<>(), odd = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) even.add(nums[j]);
                else odd.add(nums[j]);
                if (odd.size() == even.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}