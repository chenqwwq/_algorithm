package top.chenqwwq.leetcode.contest.weekly._348._2;

/**
 * @author chenqwwq
 * @date 2023/6/4
 **/
public class Solution {
    public int semiOrderedPermutation(int[] nums) {
        final int n = nums.length;
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) a = i;
            else if (nums[i] == n) b = i;
        }
        return a + n - 1 - b - (a > b ? 1 : 0);
    }
}