package top.chenqwwq.leetcode.lcp._2022_fall._3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/9/24
 **/
public class Solution {
    // 下 左 上 右
    int[] cx = new int[]{-1, 0, 1, 0};
    int[] cy = new int[]{0, -1, 0, 1};

    String[] plate;
    int n, m;

    public int[][] ballGame(int num, String[] plate) {
        this.plate = plate;
        this.n = plate.length;
        this.m = plate[0].length();
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < m - 1; i++) {
            if (plate[0].charAt(i) == '.' && ballGame(0, i, 2, num)) ans.add(new int[]{0, i});
            if (plate[n - 1].charAt(i) == '.' && ballGame(n - 1, i, 0, num)) ans.add(new int[]{n - 1, i});
        }

        for (int i = 1; i < n - 1; i++) {
            if (plate[i].charAt(0) == '.' && ballGame(i, 0, 3, num)) ans.add(new int[]{i, 0});
            if (plate[i].charAt(m - 1) == '.' && ballGame(i, m - 1, 1, num)) ans.add(new int[]{i, m - 1});
        }
        int[][] ret = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) ret[i] = ans.get(i);
        return ret;
    }

    // 上 -> 左 -> 下 -> 右
    // 上 -> 右 -> 下 -> 左
    public boolean ballGame(int x, int y, int dir, int num) {
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (plate[x].charAt(y) == 'O') return true;
        if (num <= 0) return false;
        if (plate[x].charAt(y) == 'W') dir = (dir + 1 + 4) % 4;
        else if (plate[x].charAt(y) == 'E') dir = (dir - 1 + 4) % 4;
        return ballGame(x + cx[dir], y + cy[dir], dir, num - 1);
    }
}