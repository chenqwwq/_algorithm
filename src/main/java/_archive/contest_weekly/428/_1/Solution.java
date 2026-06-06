package top.chenqwwq.leetcode.contest.weekly._428._1;

/**
 * @author chenqwwq
 * @date 2024/12/15
 **/
public class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int max = events[0][1], ans = events[0][0];
        for (int i = 1; i < events.length; i++) {
            final int kk = events[i][1] - events[i - 1][1];
            if (kk > max || (kk == max && events[i][0] < ans)) {
                ans = events[i][0];
                max = kk;
            }
        }
        return ans;
    }
}