package top.chenqwwq.leetcode.contest.biweek._38._2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chen
 * @date 2020/10/31
 **/
public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        final int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}