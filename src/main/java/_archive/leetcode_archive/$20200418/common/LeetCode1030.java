package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1030. 距离顺序排列矩阵单元格
 *
 * @author chen
 * @date 19-4-21
 */
public class LeetCode1030 {
    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int[][] res = new int[R * C][2];
            int num = 0;
            // 以(r0,c0)为起点 向外扩展 x,y分别+1,-1
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{r0, c0});
            int[][] visited = new int[R][C];
            while (!queue.isEmpty()) {
                // 从队列中弹出一个元素
                final int[] poll = queue.poll();
                // 元素表示的坐标判断
                final int i = poll[0];
                final int j = poll[1];
                if (i < 0 || i >= R || j < 0 || j >= C || visited[i][j] == 1) {
                    continue;
                }
                // 设置访问标记
                visited[i][j] = 1;
                res[num++] = poll;

                // 0,1 分别做加减
                queue.offer(new int[]{i + 1, j});
                queue.offer(new int[]{i - 1, j});
                queue.offer(new int[]{i, j + 1});
                queue.offer(new int[]{i, j - 1});
            }
            return res;
        }
    }
}
