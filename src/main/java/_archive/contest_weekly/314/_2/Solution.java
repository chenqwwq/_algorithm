package top.chenqwwq.leetcode.contest.weekly._314._2;

/**
 * @author chenqwwq
 * @date 2022/10/23
 **/
public class Solution {
    public int[] findArray(int[] pref) {
        final int n = pref.length;
        if(n <= 1) return pref;
        int[] ans = new int[n];
        ans[0] = pref[0];
        for(int i = 1;i < n;i++) ans[i] = pref[i] ^ pref[i-1];
        return ans;
    }
}