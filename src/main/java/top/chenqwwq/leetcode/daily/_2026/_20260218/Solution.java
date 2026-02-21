package top.chenqwwq.leetcode.daily._2026._20260218;

/**
 * @author chenqwwq
 * @date 2026/2/18
 **/
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = (n >> 1) ^ n;
        return ((x + 1) & x) == 0;
    }
}