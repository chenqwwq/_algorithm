package top.chenqwwq.leetcode.contest.biweek._177._3;

/**
 * @author chenqwwq
 * @date 2026/3/1
 **/
public class Solution {
    public int[] makeParityAlternating(int[] nums) {
        if (nums.length == 1) {
            return new int[]{0, 0};
        }

        int gMin = Integer.MAX_VALUE;
        int gMax = Integer.MIN_VALUE;
        for (int x : nums) {
            gMin = Math.min(gMin, x);
            gMax = Math.max(gMax, x);
        }

        int[] res1 = calc(0, nums, gMin, gMax);
        int[] res2 = calc(1, nums, gMin, gMax);

        int op1 = res1[0], minD1 = res1[1];
        int op2 = res2[0], minD2 = res2[1];
        if (op1 < op2 || op1 == op2 && minD1 < minD2) {
            return new int[]{op1, minD1};
        }
        return new int[]{op2, minD2};
    }

    private int[] calc(int target, int[] nums, int gMin, int gMax) {
        int op = 0;
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (((x - i) & 1) != target) { // 等价于 (x&1) != (target ^ (i%2))
                op++;
                if (x == gMin) {
                    x++;
                } else if (x == gMax) {
                    x--;
                }
            }
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }
        return new int[]{op, Math.max(mx - mn, 1)}; // 在 n >= 2 的情况下，极差至少是 1
    }
}