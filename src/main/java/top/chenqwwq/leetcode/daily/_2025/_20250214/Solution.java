package top.chenqwwq.leetcode.daily._2025._20250214;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/2/14
 **/
public class Solution {
    public int maxDistance(int[] position, int m) {
        if (m <= 1) return 0;
        final int n = position.length;
        Arrays.sort(position);
        if (m == 2) return position[n - 1] - position[0];
        int l = 1, r = position[n - 1] - position[0];
        int ans = -1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(position, m, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int[] position, int m, int k) {
        final int n = position.length;
        for (int i = 0, j = 0; j < n; j++) {
            if (position[j] - position[i] >= k) {
                if (--m <= 0) return true;
                i = j;
            }
        }
        return m <= 1;
    }
}