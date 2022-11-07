package top.chenqwwq.leetcode.daily._20221013;

import org.apache.commons.math3.exception.MathArithmeticException;

/**
 * @author chenqwwq
 * @date 2022/10/13
 **/
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        final int n = arr.length;
        int[] stack = new int[n];
        int p = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (p != -1 && i > stack[p]) p--;
            if (p == -1){
                stack[++p] = arr[i];
                ans++;
            } else if (stack[p] < arr[i]){
                stack[++p] = arr[i];
            }
        }
        return ans;
    }
}