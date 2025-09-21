package top.chenqwwq.leetcode.contest.biweek._120._1;

/**
 * @author chenqwwq
 * @date 2023/12/23
 **/
public class Solution {

    public int incremovableSubarrayCount(int[] nums) {
        final int n = nums.length;
        // 处理特殊情况
        if (n == 1) return 2;
        if (nums[0] >= nums[n - 1]) return 3;

        // 左边为起点的最大递增长度
        int q = 1, p = 1;
        for (; q < n; q++) {
            if (nums[q] <= nums[q - 1]) break;
        }
        // 如果全部递增,那就可以随便取
        if (q == n) return get(n);
        // 右边为终点的最大递增长度
        for (; p < n; p++) {
            if (nums[n - p - 1] >= nums[n - p]) break;
        }

        int l = q, r = n - p;
        return -1;
    }

    private int get(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i;
        }
        return ans;
    }
}