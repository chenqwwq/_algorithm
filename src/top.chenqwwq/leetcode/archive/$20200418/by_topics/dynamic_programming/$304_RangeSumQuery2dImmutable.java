package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * <p>
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * <p>
 * Range Sum Query 2D
 * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
 * <p>
 * 示例:
 * <p>
 * 给定 matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 说明:
 * <p>
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 *
 * @author chen
 * @date 2019/12/25 下午11:15
 */
public class $304_RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
//        System.out.println(numMatrix.sumRegion(0, 0, 1, 1));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    static class NumMatrix {
        /**
         * CACHE中(i,j)表示第i行0~j(左闭右闭)的和
         * // (i,j)还能保存为(0,0)到(i,j)的面积
         */
        private int[][] CACHE;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                CACHE = new int[0][0];
                return;
            }
            CACHE = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < CACHE.length; i++) {
                int sum = 0;
                for (int j = 0; j < CACHE[0].length; j++) {
                    CACHE[i][j] = (sum += matrix[i][j]);
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // 假定四个参数范围正确
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += (CACHE[i][col2] - (col1 == 0 ? 0 : CACHE[i][col1 - 1]));
            }
            return sum;
        }
    }
}
