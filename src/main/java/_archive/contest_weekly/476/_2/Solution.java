package top.chenqwwq.leetcode.contest.weekly._476._2;

/**
 * @author chenqwwq
 * @date 2025/11/16
 **/
public class Solution {
    public int minLengthAfterRemovals(String s) {
        int[] cnt = new int[2];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        return Math.abs(cnt[0] - cnt[1]);
    }
}