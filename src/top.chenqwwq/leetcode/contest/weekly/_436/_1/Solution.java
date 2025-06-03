package top.chenqwwq.leetcode.contest.weekly._436._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2025/2/9
 **/
public class Solution {
    public int[][] sortMatrix(int[][] grid) {
        final int n = grid.length, m = grid[0].length;

        List<Integer> nums = new ArrayList<>();
        // 右上角 - 倒叙
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n && j + i < m; j++) {
                nums.add(grid[j][i + j]);
            }

            nums.sort(Integer::compareTo);
            for (int j = 0; j < n && j + i < m; j++) {
                grid[j][i + j] = nums.get(j);
            }
            nums.clear();
        }

        // 左下角
        for (int i = 0; i < m; i++) {
            for (int j = 0; j + i < n && j < m; j++) {
                nums.add(grid[i + j][j]);
            }

            nums.sort(((Comparator<Integer>) Integer::compare).reversed());
            for (int j = 0; j + i < n && j < m; j++) {
                grid[i + j][j] = nums.get(j);
            }
            nums.clear();
        }

        return grid;
    }
}