package top.chenqwwq.leetcode.daily._20221025;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author chenqwwq
 * @date 2022/10/25
 **/
public class Solution {
    int[] cx = {0, 0, 1, -1};
    int[] cy = {1, -1, 0, 0};

    public int shortestBridge(int[][] grid) {
        // 先dfs找到其中一个岛屿所有的1
        // 再bfs向外扩展0，逐层扩展
        final int n = grid.length, m = grid[0].length;
        Deque<int[]> deque = new LinkedList<>();
        outer:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                Stack<int[]> stack = new Stack<>();
                grid[i][j] = 2;
                stack.push(new int[]{i, j});
                deque.push(new int[]{i, j});
                while (!stack.isEmpty()) {
                    int[] pop = stack.pop();
                    for (int q = 0; q < 4; q++) {
                        int x = pop[0] + cx[q];
                        int y = pop[1] + cy[q];
                        if (x < 0 || y < 0 || x >= m || y >= m || grid[x][y] != 1) continue;
                        grid[x][y] = 2;
                        stack.push(new int[]{x, y});
                        deque.push(new int[]{x, y});
                    }
                }
                break outer;
            }
        }
        // bfs 向外层扩展
        int ans = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                int[] pop = deque.pollFirst();
                for (int k = 0; k < 4; k++) {
                    int x = pop[0] + cx[k], y = pop[1] + cy[k];
                    if (x < 0 || y < 0 || x >= m || y >= m || grid[x][y] == 2) continue;
                    if (grid[x][y] == 1) return ans;
                    // grid[x][y] == 0
                    grid[x][y] = 2;
                    deque.addLast(new int[]{x, y});
                }
            }
            ans++;
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().shortestBridge(new int[][]{{0, 1,0}, {0,0,0},{0,0,1}});
    }
}