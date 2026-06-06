package top.chenqwwq.leetcode.daily._2023._20230620;

/**
 * @author 沽酒
 * @since 2023/06/20
 */
public class Solution {
    public int maxSumDivThree(int[] nums) {
        final int n = nums.length;
        int[][] f = new int[n][3];


        return dfs(nums, f, n - 1, 0);
    }

    /**
     * @param i 从前i个数字中获取
     * @param j 余数为j的最大和
     */
    public int dfs(int[] nums, int[][] f, int i, int j) {
        if (i < 0) return -1;
        if (f[i][j] != -1) return f[i][j];
        // 关键递
        return -1;
    }
}