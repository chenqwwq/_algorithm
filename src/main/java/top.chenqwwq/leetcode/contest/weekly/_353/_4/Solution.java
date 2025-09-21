package top.chenqwwq.leetcode.contest.weekly._353._4;

/**
 * @author chenqwwq
 * @date 2023/7/9
 **/
public class Solution {
    public boolean checkArray(int[] nums, int k) {
        final int n = nums.length;
        if (k == 1) return true;
        int[] diff = new int[n];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > cur) {
                if (i + k - 1 >= n) return false;
                diff[i + k - 1] = cur - nums[i];
                cur = nums[i];
            } else if (nums[i] < cur) return false;

            cur += diff[i];
        }
        return true;
    }
}