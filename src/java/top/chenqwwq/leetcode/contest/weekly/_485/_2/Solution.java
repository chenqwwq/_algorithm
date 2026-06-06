package top.chenqwwq.leetcode.contest.weekly._485._2;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2026/1/18
 **/
public class Solution {

    public static void main(String[] args) {
        final int i = new Solution().maxCapacity(new int[]{2, 2, 2}, new int[]{3, 5, 4}, 5);
        System.out.println(i);
    }

    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        final int n = costs.length;

        int[][] ns = new int[n][2];
        for (int i = 0; i < n; i++) {
            ns[i][0] = costs[i];
            ns[i][1] = capacity[i];
        }

        // 按照花费的降序以及容量的降序排列
        Arrays.sort(ns, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o2[0], o1[0]);
        });

        int[] maxCap = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            maxCap[i] = Math.max((i < n - 1 ? maxCap[i + 1] : 0), ns[i][1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ns[i][0] >= budget) {
                continue;
            }
            int t = budget - ns[i][0] - 1;      // 剩余消费
            int cap = ns[i][1];
            if (t <= 0) ans = Math.max(ans, cap);
            else {
                int idx = search(ns, t, i + 1, n - 1);
                if (idx != -1) ans = Math.max(ans, cap + maxCap[idx]);
                else ans = Math.max(ans, cap);
            }
        }
        return ans;
    }

    private int search(int[][] ns, int target, int l, int r) {
        // ns 按照 ns[i][0] 的降序 排列,找到第一个小于 target 的下标
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (ns[mid][0] < target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}