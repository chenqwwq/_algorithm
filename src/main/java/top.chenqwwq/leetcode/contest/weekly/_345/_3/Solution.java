package top.chenqwwq.leetcode.contest.weekly._345._3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenqwwq
 * @date 2023/5/14
 **/
public class Solution {

    int[] cx = {-1, 0, 1};

    public int maxMoves(int[][] grid) {
        final int n = grid.length, m = grid[0].length;
        if (m == 1) return 0;

        // 从第一列开始
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) queue.addLast(i);

        // 当前是第一次移动
        int cur = 0;
        while (!queue.isEmpty() && cur < m - 1) {
            int size = queue.size();
            boolean[] hash = new boolean[n];
            // 可以到下一列的哪些位置
            for (int i = 0; i < size; i++) {
                final Integer x = queue.pollFirst();
                for (int j = 0; j < 3; j++) {
                    int xx = x + cx[j];
                    // 需要下一列的值大于当前列
                    if (xx < 0 || xx >= n || hash[xx] || grid[xx][cur + 1] <= grid[x][cur]) continue;
                    hash[xx] = true;
                    queue.addLast(xx);
                }
            }
            if (!queue.isEmpty()) cur++;
        }
        return cur;
    }
}