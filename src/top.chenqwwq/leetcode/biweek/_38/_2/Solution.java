package top.chenqwwq.leetcode.biweek._38._2;

import java.util.Arrays;

/**
 * @author chen
 * @date 2020/10/31
 **/
public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int[] arr = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            ans = Math.max(ans, arr[i] - arr[i - 1]);
        }

        return ans;
    }
}