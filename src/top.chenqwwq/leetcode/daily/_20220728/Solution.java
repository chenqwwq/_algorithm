package top.chenqwwq.leetcode.daily._20220728;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 沽酒
 * @since 2022/07/28
 */
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        final int n = arr.length;
        int[] sorted = new int[n];
        System.arraycopy(arr, 0, sorted, 0, n);
        Arrays.sort(sorted);
        Map<Integer, Integer> val2Pos = new HashMap<>();
        for (int i = 0,j = 1; i < n; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }
            val2Pos.put(sorted[i], j++);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = val2Pos.get(arr[i]);
        }
        return arr;
    }
}