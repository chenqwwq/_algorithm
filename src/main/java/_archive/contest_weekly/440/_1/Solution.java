package top.chenqwwq.leetcode.contest.weekly._440._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/3/9
 **/
public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        final int n = fruits.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = -1;
                    cnt++;
                    break;
                }
            }
        }
        return n - cnt;
    }
}