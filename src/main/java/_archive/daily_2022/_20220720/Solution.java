package top.chenqwwq.leetcode.daily._2022._20220720;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/7/20
 **/
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        // 真的蠢，一定要返回 List
        int t = n * m;
        k %= t;
        int x = k / m, y = k % m;
        List<List<Integer>> ans = new ArrayList<>(n);;
        for(int i = 0;i < n;i++){
            List<Integer> e = new ArrayList<>(m);
            ans.add(e);
            for(int j =0;j < m;j++){
                e.add(0);
            }
        }
        for (int i = 0;i < n;i++){
            for (int j = 0; j < m; j++) {
                ans.get(x).set(y, grid[i][j]);
                x = (x + (++y / m)) % n;
                y %= m;
            }
        }
        return ans;
    }
}