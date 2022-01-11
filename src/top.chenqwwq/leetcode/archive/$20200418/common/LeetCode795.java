package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * @author chen
 * @description
 * @email ai654778@vip.qq.com
 * @date 19-1-23
 */
public class LeetCode795 {
    static class Solution {
        public int numSubarrayBoundedMax(int[] A, int L, int R) {
            int result = 0, startSign = 0, tempCount = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i] >= L && A[i] <= R) {
                    tempCount = i - startSign + 1;
                    result += tempCount;
                } else if (A[i] < L) {
                    result += tempCount;
                } else {
                    startSign = i + 1;
                    tempCount = 0;
                }
            }
            return result;
        }
    }
}
