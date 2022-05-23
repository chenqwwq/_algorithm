package top.chenqwwq.leetcode.daily._20220520;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/5/20
 **/
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        final int n = intervals.length;
        int[][] sort = new int[n][2];
        for (int i = 0; i < n; i++) {
            sort[i][0] = intervals[i][0];
            sort[i][1] = i;
        }
        Arrays.sort(sort, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int target = intervals[i][0];
            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (sort[mid][0] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            ans[i] = l < n ? sort[l][1] : -1;
        }
        return ans;
    }
}
