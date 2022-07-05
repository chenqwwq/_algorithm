package top.chenqwwq.leetcode.daily._20220704;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 沽酒
 * @since 2022/07/04
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        final int n = arr.length;

        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            final int diff = arr[i + 1] - arr[i];
            if (diff <= min) {
                List<Integer> date = new ArrayList<>();
                date.add(arr[i]);
                date.add(arr[i + 1]);
                ans.add(date);
            }
            if (diff < min) {
                ans.clear();
                min = diff;
            }
        }
        return ans;
    }
}