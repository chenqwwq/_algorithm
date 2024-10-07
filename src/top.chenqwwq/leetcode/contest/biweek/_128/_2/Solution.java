package top.chenqwwq.leetcode.contest.biweek._128._2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2024/4/14
 **/
public class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        final int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int cur = -1, ans = 0;
        for (int[] point : points) {
            if (point[0] > cur) {
                ans++;
                cur = point[0] + w;
            }
        }
        return ans;
    }
}