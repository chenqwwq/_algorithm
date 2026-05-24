package top.chenqwwq.leetcode.contest.weekly._494._3;

/**
 * @author chenqwwq
 * @date 2026/3/22
 **/
public class Solution {
    public int minRemovals(int[] nums, int target) {
        int tx = 0;
        for (int num : nums) tx ^= num;
        if (tx == target) return 0;

        // 需要在 nums 中找出异或值为 target ^ tx 的
        int tt = target ^ tx;
        for (int num : nums) if (tt == num) return 1;

        // 需要异或多个数的结果组成 tt

        return 1;
    }
}