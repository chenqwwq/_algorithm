package top.chenqwwq.leetcode.contest.weekly._290._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/4/24
 **/
public class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int m = rectangles.length, n = points.length;
        List<Integer>[] data = new ArrayList[101];
        for (int i = 0; i <= 100; i++) {
            data[i] = new ArrayList<>();
            data[i].add(-1);
        }
        for (int[] r : rectangles) {
            for (int i = 1; i <= r[1]; i++) {
                data[i].add(r[0]);
            }
        }
        for (int i = 0; i <= 100; i++) {
            data[i].sort(Integer::compareTo);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            ans[i] = data[y].size() - 1 - find(data[y], x);
        }
        return ans;
    }

    int find(List<Integer> data, int val) {
        // data 升序
        // 找到 data 中第一个小于 val 的值
        int l = 0, r = data.size() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (data.get(mid) >= val) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}