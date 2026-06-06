package top.chenqwwq.leetcode.contest.biweek._146._3;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/12/21
 **/
public class Solution {
    boolean checkValidCuts(int n, int[][] rectangles) {
        int m = rectangles.length;
        int[][] a = new int[m][2];
        int[][] b = new int[m][2];
        for (int i = 0; i < m; i++) {
            int[] rect = rectangles[i];
            a[i][0] = rect[0];
            a[i][1] = rect[2];
            b[i][0] = rect[1];
            b[i][1] = rect[3];
        }
        return check(a) || check(b);
    }

    private boolean check(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 按照左端点从小到大排序
        int cnt = 0;
        int maxR = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= maxR) { // 新区间
                cnt++;
            }
            maxR = Math.max(maxR, interval[1]); // 更新右端点最大值
        }
        return cnt >= 3;
    }
}