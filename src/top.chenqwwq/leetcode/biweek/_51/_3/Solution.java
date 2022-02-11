package top.chenqwwq.leetcode.biweek._51._3;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/5/1
 **/
public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = ++max;
            } else {
                max = Math.max(arr[i], max);
            }
        }
        return max;
    }
}