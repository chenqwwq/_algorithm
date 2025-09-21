package top.chenqwwq.leetcode.daily._2023._20230606;

import java.util.*;

/**
 * @author 沽酒
 * @since 2023/06/06
 */
public class Solution {
    public int equalPairs(int[][] grid) {
        int  n = grid[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = grid[j][i];
            }
            list.add(arr);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(grid[i], list.get(j))) {
                    ans++;
                }
            }
        }
        return ans;
    }
}