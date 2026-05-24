package top.chenqwwq.leetcode.daily._2026._20260322;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/3/22
 **/
public class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            rotate(mat);
        }
        return false;
    }

    // 48. 旋转图像
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int[] row = matrix[i];
            for (int j = i + 1; j < n; j++) { // 遍历对角线上方元素，做转置
                int tmp = row[j];
                row[j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
            for (int j = 0; j < n / 2; j++) { // 遍历左半元素，做行翻转
                int tmp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = tmp;
            }
        }
    }
}