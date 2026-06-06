package top.chenqwwq.leetcode.contest.weekly._379._1;

/**
 * @author chenqwwq
 * @date 2024/1/7
 **/
public class Solution {
    public int areaOfMaxDiagonal(int[][] ds) {
        int ans = -1, len = 0;
        for (int[] d : ds) {
            final int cur = d[0] * d[0] + d[1] * d[1];
            if (cur >= len) {
                ans = cur > len ? d[0] * d[1] : Math.max(ans, d[0] * d[1]);
                len = cur;
            }
        }
        return ans;
    }

}