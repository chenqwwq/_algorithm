package top.chenqwwq.leetcode.contest.weekly._490._1;

/**
 * @author chenqwwq
 * @date 2026/2/22
 **/
public class Solution {
    public int scoreDifference(int[] nums) {
        final int n = nums.length;
        int[] cs = new int[2];
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 1) flag = 1 - flag;
            if ((i + 1) % 6 == 0) flag = 1 - flag;
            cs[flag] += nums[i];
        }
        return cs[0] - cs[1];
    }
}