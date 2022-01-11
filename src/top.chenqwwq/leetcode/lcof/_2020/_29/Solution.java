package top.chenqwwq.leetcode.lcof._2020._29;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。*
 *
 * @author chen
 * @date 2020-07-03
 **/
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        if (matrix.length == 1) {
            return matrix[0];
        }

        // v纵坐标长度 h代表横坐标长度
        int v = matrix.length, h = matrix[0].length;
        int[] res = new int[v * h];
        int i, j, level = 0;
        int count = 0;
        while (count < v * h) {
            j = level;
            i = level;
            // 顶边
            while (j < h - level) {
                res[count++] = matrix[i][j++];
            }
            if (count == v * h) {
                return res;
            }
            j--;

            // 右边
            while (++i < v - level) {
                res[count++] = matrix[i][j];
            }
            if (count == v * h) {
                return res;
            }
            i--;

            // 底边
            while (--j >= level) {
                res[count++] = matrix[i][j];
            }
            if (count == v * h) {
                return res;
            }
            j++;

            level++;
            // 左边
            while (--i >= level) {
                res[count++] = matrix[i][j];
            }
            if (count == v * h) {
                return res;
            }
        }

        return res;
    }
}
