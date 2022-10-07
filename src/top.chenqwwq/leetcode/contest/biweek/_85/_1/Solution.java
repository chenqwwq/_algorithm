package top.chenqwwq.leetcode.contest.biweek._85._1;

/**
 * @author chenqwwq
 * @date 2022/8/20
 **/
public class Solution {
    public int minimumRecolors(String blocks, int k) {
        final int n = blocks.length();
        int cnt = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            char c = blocks.charAt(i);
            if (c == 'W') {
                cnt++;
            }
            if (i >= k - 1) {
                ans = Math.min(ans, cnt);
                if (blocks.charAt(i - k + 1) == 'W') {
                    cnt--;
                }
            }
        }
        return ans;
    }
}