package top.chenqwwq.leetcode.daily._2026._20260414;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/4/14
 **/
public class Solution {


    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        final int n = robot.size(), m = factory.length;
        robot.sort(Integer::compare);
        Arrays.sort(factory, Comparator.comparingInt(o -> o[0]));

        long ans = -1;
        for (int i = 0; i < m; i++) {
        }

        return ans;
    }
}