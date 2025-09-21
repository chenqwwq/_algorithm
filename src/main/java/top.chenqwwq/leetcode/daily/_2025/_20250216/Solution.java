package top.chenqwwq.leetcode.daily._2025._20250216;

/**
 * @author chenqwwq
 * @date 2025/2/16
 **/
public class Solution {
    public int[] replaceElements(int[] arr) {
        final int n = arr.length;
        int[] ans = new int[n];
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = max;
            max = Integer.max(max, arr[i]);
        }
        return ans;
    }
}