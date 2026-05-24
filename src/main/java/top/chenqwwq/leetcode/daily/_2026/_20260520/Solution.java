package top.chenqwwq.leetcode.daily._2026._20260520;

/**
 * @author chenqwwq
 * @date 2026/5/23
 **/
public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        final int n = A.length;
        long sa = 0, sb = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            sa |= 1L << A[i];
            sb |= 1L << B[i];
            ans[i] = Long.bitCount(sa & sb);
        }
        return ans;
    }
}


// 20,2,14,19,31,9,30,13,17,33
// 7, 1, 3, 5,11,2,16,26,4,13