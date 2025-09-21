package top.chenqwwq.leetcode.contest.weekly._305._4;

/**
 * @author chenqwwq
 * @date 2022/8/7
 **/
public class Solution {
    public int longestIdealString(String s, int k) {
        final int n = s.length();
        int[] lens = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);int idx = c - 'a';
            int max = 0;
            for (int j = Math.max(0, idx - k); j <= Math.min(25, idx + k); j++) {
                max = Math.max(max,lens[j] + 1);
            }
            lens[idx] = max;
        }
        int ans = 0;
        for (int num : lens) {
            ans = Math.max(num, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().longestIdealString("acfgbd", 2);
    }
}