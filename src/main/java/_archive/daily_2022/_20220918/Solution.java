package top.chenqwwq.leetcode.daily._2022._20220918;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/9/18
 **/
public class Solution {
    private final int[] cx = new int[]{1, -1, 0, 0}, cy = new int[]{0, 0, 1, -1};
    private static final int N = 510;
    int[] ps = new int[N * N], size = new int[N * N];

    int find(int a) {
        if (ps[a] != a) ps[a] = find(ps[a]);
        return ps[a];
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;
        if (size[pa] > size[pb]) union(b, a);
        else {
            size[pb] += size[pa];
            ps[pa] = ps[pb];
        }
    }

    int getMask(int i, int j) {
        return i * n + j + 1;
    }

    int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        for (int i = 1; i <= n * n; i++) {
            ps[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                for (int p = 0; p < 4; p++) {
                    int x = i + cx[p], y = j + cy[p];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                    union(getMask(x, y), getMask(i, j));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) ans = Math.max(ans, size[find(getMask(i, j))]);
                else {
                    // 寻找周边的联通块
                    int tot = 1;
                    Set<Integer> roots = new HashSet<>();
                    for (int p = 0; p < 4; p++) {
                        int x = i + cx[p], y = j + cy[p];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                        int root = find(getMask(x, y));
                        if (roots.contains(root)) continue;
                        tot += size[root];
                        roots.add(root);
                    }
                    ans = Math.max(ans, tot);
                }
            }
        }
        for (int i = 1;i <= 4;i++){
            System.out.println(size[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().largestIsland(new int[][]{{0, 1}, {1, 0}});
    }
}