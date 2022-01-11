package top.chenqwwq.leetcode.archive.$20200418.by_topics.array;

/**
 * 905. Sort Array By Parity
 * Easy
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * @author bingxin.chen
 * @date 2019/10/11 12:04
 */
public class $905_SortArrayByParity {
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            // 指针指向最后一位奇数
            int even = -1;
            // 遍历判断是否为偶数,偶数就前移到目前首个奇数之前
            for (int i = 0; i < A.length; i++) {
                if ((A[i] & 1) == 0) {
                    if (even != -1 && even != i) {
                        // 交换并进一
                        A[i] ^= A[even];
                        A[even] ^= A[i];
                        A[i] ^= A[even++];
                    }
                    continue;
                }
                if (even == -1) {
                    even = i;
                }
            }
            return A;
        }
    }
}
