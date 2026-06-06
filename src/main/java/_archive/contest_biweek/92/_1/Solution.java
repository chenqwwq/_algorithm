package top.chenqwwq.leetcode.contest.biweek._92._1;

/**
 * @author chenqwwq
 * @date 2022/11/27
 **/
public class Solution {
    public int numberOfCuts(int n) {
        if(n == 1) return 0;
        return (n & 1) == 0 ? (n >> 1) : n;
    }
}