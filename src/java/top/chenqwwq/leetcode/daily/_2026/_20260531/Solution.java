package top.chenqwwq.leetcode.daily._2026._20260531;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/5/31
 **/
public class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int num : asteroids) {
            if (mass < num) return false;
            mass += num;
        }
        return true;
    }
}