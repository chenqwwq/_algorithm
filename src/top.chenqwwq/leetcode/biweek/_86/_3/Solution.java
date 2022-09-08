package top.chenqwwq.leetcode.biweek._86._3;

import java.awt.font.LineMetrics;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/9/3
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().maximumRows(new int[][]{{0,0,0},{1,0,1},{0,1,1},{0,0,1}},2);
    }
    int n, m;

    public int maximumRows(int[][] mat, int cols) {
        n = mat.length;
        m = mat[0].length;
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i] += mat[i][j];
            }
        }
        return dfs(mat,cols,0,sum);
    }

    Map<Integer, Integer> cache = new HashMap<>();

    public int dfs(int[][] mat, int cols, int vis, int[] sum) {
        if (cache.containsKey(vis)) {
            return cache.get(vis);
        }
        if (cols <= 0) {
            int cnt = 0;
            for (int su : sum) {
                if (su <= 0) {
                    cnt++;
                }
            }
            cache.put(vis,cnt);
            return cnt;
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            if ((vis & (1 << i)) == 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                sum[j] -= mat[j][i];
            }
            max = Math.max(max, dfs(mat, cols-1, vis | (1 << i), sum));
            for (int j = 0; j < n; j++) {
                sum[j] += mat[j][i];
            }
        }
        cache.put(vis,max);
        return max;
    }
}
