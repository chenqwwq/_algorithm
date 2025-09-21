package top.chenqwwq.leetcode.contest.weekly._304._2;

/**
 * @author chenqwwq
 * @date 2022/7/31
 **/
public class Solution {
    public int maximumGroups(int[] grades) {
        final int n = grades.length;
        int sum = 0;
        for (int i = 1; i <= n + 1; i++) {
            sum += i;
            if (sum > n) {
                return i-1;
            }
        }
        return 0;
    }
}