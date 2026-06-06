package top.chenqwwq.leetcode.contest.weekly._291._4;

/**
 * @author chenqwwq
 * @date 2022/5/1
 **/
public class Solution {
    public long appealSum(String s) {
        final int n = s.length();
        int[] last = new int[26];
        s = " " + s;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += (long) (i - last[s.charAt(i) - 'a']) * (n - i + 1);
            last[s.charAt(i) - 'a'] = i;
        }
        return ans;
    }
}