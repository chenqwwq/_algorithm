package top.chenqwwq.leetcode.archive.$20200418.by_topics.dynamic_programming;

/**
 * @author bingxin.chen
 * @date 2019/12/26 09:50
 */
public class $304_RangeSumQuery2dImmutable_2 {
    class NumMatrix {
        /**
         * cache(i,j)表示(0,0)->(i,j)的和
         */
        private int[][] cache;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                cache = new int[0][0];
                return;
            }

            cache = new int[matrix.length][matrix[0].length];

            // rowCache[i]记录的是i行的当前记录
            int[] rowCache = new int[matrix.length];

            // 外层循环,遍历行内
            for (int i = 0; i < matrix[0].length; i++) {
                int sum = 0;
                // 内存循环,遍历列
                for (int j = 0; j < matrix.length; j++) {
                    // 更新每行值缓存
                    rowCache[j] += matrix[j][i];
                    sum += rowCache[j];
                    cache[j][i] = sum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return cache[row2][col2] +
                    (row1 > 0 && col1 > 0 ? cache[row1 - 1][col1 - 1] : 0) -
                    (col1 > 0 ? cache[row2][col1 - 1] : 0) -
                    (row1 > 0 ? cache[row1 - 1][col2] : 0);
        }
    }
}
