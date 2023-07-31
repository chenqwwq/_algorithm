package top.chenqwwq.leetcode.contest.weekly._346._2;

/**
 * @author chenqwwq
 * @date 2023/5/22
 **/
public class Solution {
    public String makeSmallestPalindrome(String s) {
        final int n = s.length();
        int l = 0, r = n - 1;
        final char[] cs = s.toCharArray();
        int ans = 0;
        while (l < r) {
            if (cs[l] != cs[r]) {
                if(cs[l] < cs[r]) cs[r] = cs[l];
                else cs[l] = cs[r];
            }
            l++;
            r--;
        }
        return new String(cs);
    }
}