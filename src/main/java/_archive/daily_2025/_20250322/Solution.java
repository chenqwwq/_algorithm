package top.chenqwwq.leetcode.daily._2025._20250322;

/**
 * @author chenqwwq
 * @date 2025/3/22
 **/
public class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int cur = 0, cnt = 0;
        final int n = mat.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[i][j];
            }
            if (sum > cnt) cur = i;
        }
        return mat[cur];
    }
}