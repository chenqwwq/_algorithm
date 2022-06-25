package top.chenqwwq.leetcode.weekly._298._3;

import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/6/19
 **/
public class Solution {
    public int longestSubsequence(String s, int k) {
        final int n = s.length();
        int curr = 0, sum = 0;
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            curr = (curr << 1) + (s.charAt(r) - '0');
            while (curr > k) {
                while (l < r && s.charAt(l) != '1') {
                    sum++;
                    l++;
                }
                curr -= (1 << (r - l++));
            }
            ans = Math.max(ans, r - l + 1 + sum);
        }
        return ans;
    }
}