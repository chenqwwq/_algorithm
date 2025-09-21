package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 941. Valid Mountain Array
 * Easy
 * <p>
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * @author chen
 * @date 19-7-13 下午2:10
 */
public class LeetCode941 {

    public static void main(String[] args) {
        System.out.println(new LeetCode941().new Solution().validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    }

    class Solution {
        public boolean validMountainArray(int[] A) {
            if (A == null || A.length < 3) {
                return false;
            }
            int i = 0;
            int length = A.length;
            // 从数组头开始遍历,知道有下落趋势
            while (++i < length && A[i - 1] <= A[i]) {
            }

            if (i == length || i == 1) {
                return false;
            }

            while (++i < length) {
                if (A[i - 1] <= A[i]) {
                    return false;
                }
            }

            return true;

        }
    }
}
