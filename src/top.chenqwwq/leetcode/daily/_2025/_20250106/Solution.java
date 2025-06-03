package top.chenqwwq.leetcode.daily._2025._20250106;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/1/6
 **/
public class Solution {
    public int maxConsecutive(int l, int r, int[] s) {
        if (s.length == 0) return r - l + 1;
        final int n = s.length;
        Arrays.sort(s);
        int ans = 0;
        for (int i = 0; i < n && l <= r; i++) {
            if (s[i] > l) ans = Math.max(ans, s[i] - l);
            l = s[i] + 1;
        }
        return Math.max(ans, r - l + 1);
    }
}