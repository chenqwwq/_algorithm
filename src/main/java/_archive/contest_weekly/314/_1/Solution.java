package top.chenqwwq.leetcode.contest.weekly._314._1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2022/10/23
 **/
public class Solution {
    public int hardestWorker(int n, int[][] logs) {
        final int m = logs.length;
        int max = logs[0][1], ans = logs[0][0];
        for (int i = 1; i < m; i++) {
            final int gap = logs[i][1] - logs[i - 1][1];
            if (gap > max || (gap == max && logs[i][0] < ans)){
                max = gap;
                ans = logs[i][0];
            }
        }
        return ans;
    }
}
