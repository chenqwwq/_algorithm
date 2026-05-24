package top.chenqwwq.leetcode.daily._20260523;

/**
 * @author chenqwwq
 * @date 2026/5/23
 **/
public class Solution {
    public boolean check(int[] nums) {
        final int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) continue;
            if (flag) return false;
            flag = true;
        }
        return true;
    }
}