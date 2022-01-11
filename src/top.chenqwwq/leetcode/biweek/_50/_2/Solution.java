package top.chenqwwq.leetcode.biweek._50._2;

/**
 * @author chen
 * @date 2021/4/17
 **/
public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        if (queries == null || queries.length == 0) {
            return new int[0];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            for (int j = 0; j < points.length; j++) {
                if (isIn(queries[i][0], queries[i][1], queries[i][2], points[j][0], points[j][1])) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public boolean isIn(int a, int b, int r, int x, int y) {
        return (a - x) * (a - x) + (b - y) * (b - y) <= r * r;
    }
}
