package top.chenqwwq.leetcode.lcp._2022_fall._1;

/**
 * @author chenqwwq
 * @date 2022/9/24
 **/
public class Solution {
    public int temperatureTrend(int[] ta, int[] tb) {
        final int n = ta.length;
        int ans = 0, cur = 0;
        for (int i = 1; i < n; i++) {
            if ((ta[i] - ta[i - 1]) * (tb[i] - tb[i - 1]) > 0) ans = Math.max(ans, ++cur);
            else if ((ta[i] - ta[i - 1] == 0 && tb[i] - tb[i - 1] == 0)) ans = Math.max(ans, ++cur);
            else cur = 0;
        }
        return ans;
    }
}