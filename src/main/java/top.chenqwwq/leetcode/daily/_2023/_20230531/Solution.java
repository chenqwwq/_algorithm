package top.chenqwwq.leetcode.daily._2023._20230531;

/**
 * @author 沽酒
 * @since 2023/05/31
 */
public class Solution {
    public int mctFromLeafValues(int[] arr) {
        final int n = arr.length;
        int[] stack = new int[n];
        int idx = -1, ans = 0;
        for (int num : arr) {
            if (idx == -1 || stack[idx] >= num) stack[++idx] = num;
            else {
                while (idx > 0 && stack[idx - 1] < num) {
                    ans += stack[idx] * stack[--idx];
                }
                ans += stack[idx] * num;
                stack[idx] = num;
            }
        }
        while (idx > 0) ans += stack[idx] * stack[--idx];
        return ans;
    }
}