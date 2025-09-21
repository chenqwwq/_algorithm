package top.chenqwwq.leetcode.contest.weekly._372._2;

/**
 * @author chenqwwq
 * @date 2023/11/19
 **/
public class Solution {
    public long minimumSteps(String s) {
        final int n = s.length();
        long cnt = 0, sum = 0;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                cur += i;
                sum += cnt++;
            }
        }
        return Math.abs(sum - cur);
    }
}