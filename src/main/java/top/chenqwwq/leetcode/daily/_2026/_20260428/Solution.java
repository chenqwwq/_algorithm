package top.chenqwwq.leetcode.daily._2026._20260428;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/4/28
 **/
public class Solution {
    public int minOperations(int[][] grid, int x) {
        final int n = grid.length, m = grid[0].length;
        final int t = n * m;
        final int[] arr = new int[n * m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(grid[i], 0, arr, i * m, m);
        }
        Arrays.sort(arr);
        int min = arr[0];
        for (int i = 0; i < t; i++) {
            if ((arr[i] - min) % x != 0) return -1;
            arr[i] = (arr[i] - min) / x;
        }
        int mid = arr[t - 1] / 2;
        // 6 1 2 5
        return get(arr, mid);
    }

    public int get(int[] arr, int t) {
        int ans = 0;
        for (int num : arr) {
            ans += Math.abs(num - t);
        }
        return ans;
    }

    public static void main(String[] args) {
        final int i = new Solution().minOperations(new int[][]{{931, 128}, {639, 712}}, 73);
        System.out.println(i);
    }
}