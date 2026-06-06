package top.chenqwwq.leetcode.daily._2022._20220914;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/9/14
 **/
public class Solution {
    public double trimMean(int[] arr) {
        final int n = arr.length;
        Arrays.sort(arr);
        double ans = 0;
        for (int i = n / 20; i < n - n / 20; i++) ans += arr[i];
        return ans / (n - 2 * (n / 20));
    }
}