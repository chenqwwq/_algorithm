package top.chenqwwq.leetcode.daily._2022._20220712;

/**
 * @author 沽酒
 * @since 2022/07/12
 */
public class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] a = new int[m], b = new int[n];
        for (int[] idx : indices) {
            a[idx[0]]++;
            b[idx[1]]++;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += (a[i] + b[j]) & 1;
            }
        }
        return ans;
    }
}