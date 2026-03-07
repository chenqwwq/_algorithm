package top.chenqwwq.leetcode.daily._2026._20260302;

/**
 * @author chenqwwq
 * @date 2026/3/2
 **/
public class Solution {
    public int minSwaps(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        final int[] ps = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] == 0) cnt++;
                else break;
            }
            ps[i] = cnt;
        }


        // 模拟交换,最上排
        int ans = 0;
        next:
        for (int i = 0; i < n - 1; i++) {
            int ns = n - 1 - i;
            for (int j = i; j < n; j++) {
                if (ps[j] >= ns) {
                    ans += j - i;
                    System.arraycopy(ps, i, ps, i + 1, j - i);
                    continue next;
                }
            }
            return -1;
        }
        return ans;
    }
}