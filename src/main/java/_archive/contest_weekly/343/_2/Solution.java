package top.chenqwwq.leetcode.contest.weekly._343._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/4/30
 **/
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        final int n = mat.length, m = mat[0].length;

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rows = new int[n], cols = new int[m];
        for(int i = 0;i < arr.length;i++){
            final int[] idxs = map.get(arr[i]);
            if(++rows[idxs[0]] == m) return i;
            if(++cols[idxs[1]] == n) return i;
        }
        return -1;
    }
}