package top.chenqwwq.leetcode.daily._2023._20231201;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/12/2
 **/
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        final int n = mat.length, m = mat[0].length;
        final int[] ns = new int[n], ms = new int[m];
        final Map<Integer, int[]> num2Idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                num2Idx.put(mat[i][j], new int[]{i, j});
            }
        }

        for(int i = 0;i < arr.length;i++){
            final int[] idx = num2Idx.get(arr[i]);
            if(++ns[idx[0]] == m || ++ ms[idx[1]] == n) return i;
        }
        return -1;
    }
}