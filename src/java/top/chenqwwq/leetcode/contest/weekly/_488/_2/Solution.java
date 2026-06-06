package top.chenqwwq.leetcode.contest.weekly._488._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/2/9
 **/
public class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        final int n = nums.length;
        long[] stack = new long[n];
        int cur = 0;
        for (int in : nums) {
            stack[cur++] = in;
            while (cur >= 2 && stack[cur - 1] == stack[cur - 2]) {
                cur--;
                stack[cur - 1] <<= 1;
            }
        }

        List<Long> ret = new ArrayList<>();
        for (int i = 0; i < cur; i++) {
            ret.add(stack[i]);
        }
        return ret;
    }
}