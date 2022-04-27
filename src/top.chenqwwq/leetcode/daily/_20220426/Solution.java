package top.chenqwwq.leetcode.daily._20220426;

/**
 * @author chenqwwq
 * @date 2022/4/26
 **/
public class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        int[] rm = new int[n], cm = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    ans++;
                    rm[i] = Math.max(rm[i], grid[i][j]);
                    cm[j] = Math.max(cm[j], grid[i][j]);
                }
            }
        }
        for (int num : rm) {
            ans += num;
        }
        for (int num : cm) {
            ans += num;
        }
        return ans;
    }
}