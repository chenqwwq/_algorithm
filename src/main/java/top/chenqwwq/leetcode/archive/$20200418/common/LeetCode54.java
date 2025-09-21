package top.chenqwwq.leetcode.archive.$20200418.common;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/15 10:58
 */
@Slf4j
public class LeetCode54 {
    public static void main(String[] args) {
        int[][] i = new int[3][3];
//         i[0][0] = 7;
//         i[1][0] = 9;
//         i[2][0] = 6;
        int sign = 1;
        for (int q = 0; q < 3; q++) {
            for (int p = 0; p < 3; p++) {
                i[q][p] = sign++;
            }
        }
        log.info(new Solution().spiralOrder(i).toString());
    }

    static class Solution {
        private ArrayList<Integer> result;

        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new ArrayList<>();
            }
            int row = matrix[0].length;
            int column = matrix.length;
            result = new ArrayList<>(row * column);

            int i = 0, j = 0;
            //中心节点的i,j坐标
            int centerI = row / 2;
            int centerJ = column / 2;
            while (i <= centerI && j <= centerJ) {
                handle(matrix, i++, j++);
            }

            return result;
        }

        /**
         * 逐层遍历
         *
         * @param matrix
         */
        public void handle(int[][] matrix, int row, int column) {
            int rowLen = matrix[0].length - 2 * row;
            int columnLen = matrix.length - 2 * column;
            if (rowLen <= 0 || columnLen <= 0) {
                return;
            }
            int rowSign = row;
            int columnSign = column;

            while (rowSign < row + rowLen) {
                result.add(matrix[columnSign][rowSign++]);
            }
            rowSign--;
            columnSign++;

            while (columnSign < column + columnLen) {
                result.add(matrix[columnSign++][rowSign]);
            }
            columnSign--;
            rowSign--;

            if (columnLen == 1) {
                return;
            }

            while (rowSign >= row) {
                result.add(matrix[columnSign][rowSign--]);
            }
            rowSign++;
            columnSign--;

            if (rowLen == 1) {
                return;
            }

            while (columnSign > column) {
                result.add(matrix[columnSign--][rowSign]);
            }
        }
    }

}
