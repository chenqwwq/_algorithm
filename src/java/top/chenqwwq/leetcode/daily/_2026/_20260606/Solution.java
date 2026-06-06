package top.chenqwwq.leetcode.daily._2026._20260606;

public class Solution {
    public int[] leftRightDifference(int[] nums) {
        final int n = nums.length;
        int[] ret = new int[n],ps = new int[n],ss = new int[n];
        for(int i = 0; i < n; i++){
            ps[i] = nums[i] + (i > 0 ? ps[i - 1] : 0);
            ss[i] = nums[n - 1 - i] + (i > 0 ? ss[i - 1] : 0);
        }
        for(int i = 0; i < n; i++){
            ret[i] = Math.abs(ps[i] - ss[n - 1 - i]);
        }
        return ret;
    }
}