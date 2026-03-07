package top.chenqwwq.leetcode.daily._2026._20260301;

/**
 * @author chenqwwq
 * @date 2026/3/1
 **/
public class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for (char c : n.toCharArray()) {
            ans = Math.max(c - '0', ans);
        }
        return ans;
    }
}