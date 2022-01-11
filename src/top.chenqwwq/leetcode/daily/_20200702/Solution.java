package top.chenqwwq.leetcode.daily._20200702;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * @author chen
 * @date 2020/7/2 下午10:39
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //   [ 1,  5,  9],
        //   [10, 11, 13],
        //   [12, 13, 15]
        // 横竖相等
        int len = matrix.length;
        int min = matrix[0][0], max = matrix[len - 1][len - 1];
        while (min < max) {
            int mid = min + ((max - min) >> 1);
            // 检查矩阵内的元素比mid小的个数
            // 从左下角开始
            int i = len - 1, j = 0;
            int num = 0;
            while (i >= 0 && j < len) {
                if (matrix[i][j] <= mid) {
                    num += (i + 1);
                    j++;
                } else {
                    i--;
                }
            }
            if (num >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}