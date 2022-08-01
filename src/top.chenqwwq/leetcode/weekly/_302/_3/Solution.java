package top.chenqwwq.leetcode.weekly._302._3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2022/7/17
 **/
public class Solution {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] qs) {
        final int n = qs.length, m = nums[0].length(), c = nums.length;
        Integer[] ns = new Integer[c];
        for (int i = 0; i < c; i++) {
            ns[i] = i;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] q = qs[i];
            Arrays.sort(ns, Comparator.comparing((Integer s) -> nums[s].substring(m - q[1])).thenComparing(Integer::compareTo));
            ans[i] = ns[q[0] - 1];
        }
        return ans;
    }
}