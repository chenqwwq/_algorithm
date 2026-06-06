package top.chenqwwq.leetcode.daily._2023._20230826;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2023/8/27
 **/
public class Solution {
    public int[][] merge(int[][] intervals) {
        final int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if (list.isEmpty() || l > list.get(list.size() - 1)[1]) list.add(new int[]{l, r});
            else list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
        }
        return list.toArray(new int[list.size()][]);
    }
}