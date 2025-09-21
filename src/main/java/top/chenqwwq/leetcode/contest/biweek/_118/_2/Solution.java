package top.chenqwwq.leetcode.contest.biweek._118._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2023/11/26
 **/
public class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);
        final int mx = getMax(h), my = getMax(v);
        final int len = Math.min(mx, my);
        if (len == 1) return -1;
        return len * len;
    }

    public int getMax(int[] nums) {
        int target = 2, ans = 1;
        int len = 1;
        for (int j : nums) {
            if (j == target) {
                len++;
                target++;
            } else {
                target = j + 1;
                ans = Math.max(ans, len);
                len = 2;
            }
        }
        return Math.max(ans, len);
    }

    public static void main(String[] args) {
        new Solution().maximizeSquareHoleArea(2,4,new int[]{3,2},new int[]{4,2});
    }
}