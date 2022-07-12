package top.chenqwwq.leetcode.biweek._82._3;

import java.util.Arrays;

/**
 * @author 沽酒
 * @since 2022/07/12
 */
public class Solution {
    public long minSumSquareDiff(int[] a, int[] b, int k1, int k2) {
        final int n = a.length;
        int k = k1 + k2;  // 统计规定为 k
        long sum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(a[i] -= b[i]);
            ans += (long) a[i] * a[i];
        }
        if (sum < k) return 0;

        Arrays.sort(a);
        for (int i = n - 2; i >= 0 && k > 0; --i) {
            int diff = a[i + 1] - a[i];
            long x = (long) diff * (n - i - 2);
            if (x <= k) {
                k -= x;
                ans -= ((long) a[i + 1] * a[i + 1] - (long) a[i] * a[i]) * (n - i - 2);
            } else {
                // 没办法把 a[i+1] ~ a[n-1] 全部 从 a[i+1] 变成 a[i]
                int c = n - i - 2;
                long v = a[i + 1];
                while (k > c) {
                    int t = k / c;
                    k -= t * c;
                    ans -= (v * v - (v - t) * (v - t)) * c;
                    v -= t;
                }
                if (k > 0) ans -= (v * v - (v - 1) * (v - 1)) * k;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().minSumSquareDiff(new int[]{1,4,10,12}, new int[]{5,8,6,9}, 1, 1);
    }
}