package top.chenqwwq.leetcode.contest.weekly._424._3;

/**
 * @author chenqwwq
 * @date 2024/11/17
 **/
public class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        // 二分 + 差分数组
        int l = 0, r = queries.length;
        if (!check(nums, queries, queries.length)) {
            return -1;
        }
        while (l < r) {
            // 每次计算 0 -> mid
            int mid = (l + r) >> 1;
            final boolean ok = check(nums, queries, mid);
            if (ok) r = mid;
            else l = mid + 1;
        }
        return l;

    }

    public boolean check(int[] nums, int[][] queries, int k) {
        final int n = nums.length;
        final int[] ss = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int[] q = queries[i];
            ss[q[0]] += q[2];
            ss[q[1] + 1] -= q[2];
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if ((cur += ss[i]) < nums[i]) {
                return false;
            }
        }
        return true;
    }
}