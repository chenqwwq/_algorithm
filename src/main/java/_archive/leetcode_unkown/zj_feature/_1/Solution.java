package top.chenqwwq.leetcode.unkown.zj_feature._1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 沽酒
 * @since 2022/07/08
 */
public class Solution {
    public boolean canReceiveAllSignals(int[][] intervals) {
        final int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n - 1; i++) {
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}
