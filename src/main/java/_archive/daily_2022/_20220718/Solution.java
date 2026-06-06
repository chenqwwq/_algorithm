package top.chenqwwq.leetcode.daily._2022._20220718;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/7/18
 **/
public class Solution {
    int[] cx = new int[]{1, -1, 0, 0}, cy = new int[]{0, 0, -1, 1};

    public int containVirus(int[][] nums) {
        final int n = nums.length, m = nums[0].length;
        // 保存所有连通块
        List<Set<int[]>> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] != 1) {
                    continue;
                }
                nums[i][j] = -1;
                Set<int[]> block = new HashSet<>();
                Deque<int[]> deque = new LinkedList<>();
                deque.push(new int[]{i, j});
                block.add(new int[]{i,j});
                while (!deque.isEmpty()) {
                    int[] pop = deque.pop();
                    for (int k = 0; k < 4; k++) {
                        int x = pop[0] + cx[k], y = pop[1] + cy[k];
                        if (x < 0 || y < 0 || x >= n || y >= m || nums[x][y] != 1) {
                            continue;
                        }
                        nums[x][y] = -1;
                        int[] node = {x, y};
                        deque.push(node);
                        block.add(node);
                    }
                }
                ls.add(block);
            }
        }

        int ans = 0;
        for (int i = ls.size(); i > 0; i--) {
            int max = 0, pos = -1;
            List<Set<int[]>> nodes = new ArrayList<>();
            for (int j = 0; j < ls.size(); j++) {
                Set<int[]> s = ls.get(j);
                int cnt = 0;
                Set<int[]> ns = new HashSet<>();
                for (int[] node : s) {
                    for (int k = 0; k < 4; k++) {
                        int x = node[0] + cx[k], y = node[1] + cy[k];
                        if (x < 0 || y < 0 || x >= n || y >= m || nums[x][y] == -1) {
                            continue;
                        }
                        nums[x][y] = -1;
                        cnt++;
                        ns.add(new int[]{x, y});
                    }
                }
                nodes.add(ns);
                if (cnt > max) {
                    max = cnt;
                    pos = j;
                }
            }
            if (nodes.size() == 0) {
                return ans;
            }
            ls = nodes;
            for (int[] node : ls.remove(pos)) {
                nums[node[0]][node[1]] = -1;
            }
            System.out.println(max);
            ans += max;
        }
        return ans;
    }
}