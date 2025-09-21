package top.chenqwwq.leetcode.contest.weekly._424._2;

/**
 * @author chenqwwq
 * @date 2024/11/17
 **/
public class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        // 差分数组
        final int n = nums.length;
        final int[] ss = new int[n + 1];
        for (int[] q : queries) {
            ss[q[0]]++;
            ss[q[1] + 1]--;
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += ss[i];
            ss[i] = cur;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > ss[i]) return false;
        }
        return true;
    }
}