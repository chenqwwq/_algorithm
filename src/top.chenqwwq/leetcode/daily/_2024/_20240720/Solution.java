package top.chenqwwq.leetcode.daily._2024._20240720;

/**
 * @author chenqwwq
 * @date 2024/7/22
 **/
public class Solution {

    public int minimumMoves(int[][] grid) {
        var cs = new int[9];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(grid[i], 0, cs, i * 3, 3);
        }
        return dfs(cs, 0);
    }


    public int dfs(int[] cs, int i) {
        if (i >= 9) return 0;
        // 不需要分配了
        if (cs[i] > 0) return dfs(cs, i + 1);
        // 需要从别的节点分配石头
        int ans = 0x3f3f3f3f;
        // 枚举所有可以获取的节点
        for (var j = 0; j < 9; j++) {
            if (cs[j] <= 1) continue;
            cs[j]--;
            ans = Math.min(ans, get(i, j) + dfs(cs, i + 1));
            cs[j]++;
        }
        return ans;
    }

    public int get(int i, int j) {
        int x = i % 3, y = i / 3, xx = j % 3, yy = j / 3;
        return Math.abs(x - xx) + Math.abs(y - yy);
    }
}