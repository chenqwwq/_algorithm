package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author CheNbXxx
 * @description 动态规划 二维数组系列
 * @email chenbxxx@gmail.con
 * @date 2019/1/17 11:49
 */
@Slf4j
public class LeetCode221 {
    public static void main(String[] args) {
        System.out.println((int) '1');
    }

    static class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null) {
                return 0;
            }
            // colLen取长度时注意空判断
            int rowLen = matrix.length, colLen = rowLen == 0 ? 0 : matrix[0].length;
            int[][] dpArr = new int[rowLen][colLen];

            int max = 0;

            for (int i = 0; i < rowLen; i++) {
                dpArr[i][0] = matrix[i][0] == '1' ? 1 : 0;
                max = Math.max(max, dpArr[i][0]);
            }

            for (int i = 0; i < colLen; i++) {
                dpArr[0][i] = matrix[0][i] == '1' ? 1 : 0;
                max = Math.max(max, dpArr[0][i]);
            }
            for (int i = 1; i < rowLen; i++) {
                for (int j = 1; j < colLen; j++) {
                    if (matrix[i - 1][j - 1] == '1') {
                        dpArr[i][j] = Math.min(dpArr[i - 1][j], Math.min(dpArr[i - 1][j - 1], dpArr[i][j - 1])) + 1;
                        max = Math.max(dpArr[i][j], max);
                    }
                }
            }

            return max * max;
        }
    }
}
