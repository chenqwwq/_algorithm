package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/22 11:36
 */
public class LeetCode973 {
    static class Solution {
        public int[][] kClosest(int[][] points, int K) {
            Arrays.sort(points, Comparator.comparingDouble(one -> Math.pow(one[0], 2) + Math.pow(one[1], 2)));
            int[][] ret = new int[K][2];
            for (int i = 0; i < K; i++) {
                ret[i] = points[i];
            }
            return ret;
        }
    }
}
