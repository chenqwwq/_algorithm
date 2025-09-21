package top.chenqwwq.leetcode.contest.weekly._311._1;

/**
 * @author chenqwwq
 * @date 2022/9/18
 **/
public class Solution {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}