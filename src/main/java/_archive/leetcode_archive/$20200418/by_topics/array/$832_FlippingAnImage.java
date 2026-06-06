package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

/**
 * 832. Flipping an Image
 * Easy
 * <p>
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * <p>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * @author bingxin.chen
 * @date 2019/10/10 12:25
 */
public class $832_FlippingAnImage {

    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            // 采用与1异或转换0,1
            // 0 ^ 1 = 1
            // 1 ^ 1 = 0

            // 排除特殊情况
            if (A == null || A.length == 0) {
                return null;
            }

            // X轴的数组长度 / 2
            final int length = A[0].length;
            final int mid = (length + 1) >> 1;

            // 遍历转换
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < mid; j++) {
                    int temp = A[i][length - j - 1] ^ 1;
                    A[i][length - j - 1] = A[i][j] ^ 1;
                    A[i][j] = temp;
                }
            }

            return A;
        }
    }

}
