package top.chenqwwq.leetcode.contest.weekly._445._1;

/**
 * @author chenqwwq
 * @date 2025/4/13
 **/
public class Solution {
    public int findClosest(int x, int y, int z) {
        return Math.abs(x - z) > Math.abs(y - z) ? 1 : 2;
    }
}