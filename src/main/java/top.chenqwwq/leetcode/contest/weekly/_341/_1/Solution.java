package top.chenqwwq.leetcode.contest.weekly._341._1;

/**
 * @author chenqwwq
 * @date 2023/4/16
 **/
public class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        final int n = mat.length, m = mat[0].length;
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) cnt += mat[i][j];
            if(cnt > b) {
                b = cnt;
                a = i;
            }
        }
        return new int[]{a,b};
    }
}