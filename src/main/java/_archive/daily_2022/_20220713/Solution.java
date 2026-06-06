package top.chenqwwq.leetcode.daily._2022._20220713;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author chenqwwq
 * @date 2022/7/13
 **/
public class Solution {

    public int getRes(int l, int r) {
        int ll = Math.abs(l), rr = Math.abs(r);
        return ll == rr ? 0 : (ll < rr ? r : l);
    }

    public int[] asteroidCollision(int[] nums) {
        final int n = nums.length;
        if (n < 2) {
            return nums;
        }
        int[] stack = new int[n];
        int pos = 0;
        for (int m : nums) {
            while (m != 0 && pos > 0 && stack[pos - 1] > 0 && m < 0) {
                int ll = Math.abs(stack[--pos]), rr = Math.abs(m);
                m = ll == rr ? 0 : (ll < rr ? m : stack[pos]);
            }
            if (m != 0) {
                stack[pos++] = m;
            }
        }
        if (pos == n) {
            return stack;
        }
        int[] ans = new int[pos];
        System.arraycopy(stack, 0, ans, 0, pos);
        return ans;
    }
}