package top.chenqwwq.leetcode.contest.weekly._502._1;

/**
 * @author chenqwwq
 * @date 2026/5/17
 **/
public class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        final int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) > 2) return false;
        }
        return true;
    }
}