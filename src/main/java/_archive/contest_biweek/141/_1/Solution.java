package top.chenqwwq.leetcode.contest.biweek._141._1;

import java.util.List;

/**
 * @author chenqwwq
 * @date 2024/10/20
 **/
public class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        final int n = nums.size();
        final int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if ((num & 1) == 0) ans[i] = -1;
            else {
                int j = 0;
                while ((num & (1 << j)) != 0) j++;
                ans[i] = num ^ (1 << (j - 1));
            }
        }
        return ans;
    }
}