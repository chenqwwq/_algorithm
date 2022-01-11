package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 832. 翻转图像
 * 简单地数组操作
 *
 * @author bingxin.chen
 * @date 2019/4/16 12:51
 */

public class LeetCode832 {

    public static void main(String[] args) {
        new LeetCode832().new Solution().flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
    }

    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            if (A == null || A.length == 0 || A[0].length == 0) {
                return new int[][]{};
            }

            final int length = A[0].length;
            for (int i = 0; i < A.length; i++) {
                int[] temp = new int[length];
                System.arraycopy(A[i], 0, temp, 0, length);
                for (int j = 0; j < length; j++) {
                    A[i][j] = temp[length - j - 1] ^ 1;
                }
            }

            return A;
        }
    }
}
