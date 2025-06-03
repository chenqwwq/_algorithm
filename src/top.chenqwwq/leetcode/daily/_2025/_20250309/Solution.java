package top.chenqwwq.leetcode.daily._2025._20250309;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/3/9
 **/
public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        final int n = items.length, m = queries.length;
        Arrays.sort(items, Comparator.comparingInt((int[] o) -> o[0]).thenComparing((o1, o2) -> Integer.compare(o2[1], o1[1])));

        int[] bs = new int[n];
        bs[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            bs[i] = Math.max(bs[i - 1], items[i][1]);
        }

        // 二分找到能买得起的最大价格
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (items[mid][0] > queries[i]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            ans[i] = queries[i] >= items[l][0] ? bs[l] : 0;
        }
        return ans;
    }
}