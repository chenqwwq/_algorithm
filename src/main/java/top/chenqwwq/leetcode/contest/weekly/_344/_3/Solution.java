package top.chenqwwq.leetcode.contest.weekly._344._3;

/**
 * @author 沽酒
 * @since 2023/05/09
 */
public class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        final int m = queries.length;
        int[] color = new int[n];
        int[] ans = new int[m];
        int curr = 0;
        for (int i = 0; i < m; i++) {
            int p = queries[i][0], c = queries[i][1];
            if (color[p] != c) {
                if (p > 0) {
                    if (color[p - 1] != 0 && color[p - 1] == color[p]) curr--;
                    else if (color[p - 1] == c) curr++;
                }
                if (p < n-1) {
                    if (color[p + 1] != 0 && color[p + 1] == color[p]) curr--;
                    else if (color[p + 1] == c) curr++;
                }
                color[p] = c;
            }
            ans[i] = curr;
        }
        return ans;
    }
}