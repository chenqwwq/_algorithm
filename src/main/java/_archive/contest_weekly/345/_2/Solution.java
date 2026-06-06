package top.chenqwwq.leetcode.contest.weekly._345._2;

/**
 * @author chenqwwq
 * @date 2023/5/14
 **/
public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        final int n = derived.length;
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (derived[i] == 1) nums[i + 1] = 1 ^ nums[i];
            else nums[i + 1] = nums[i];
        }

        return derived[n - 1] == (nums[n - 1] ^ nums[0]);
    }
}