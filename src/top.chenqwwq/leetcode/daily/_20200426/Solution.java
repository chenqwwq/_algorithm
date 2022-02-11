package top.chenqwwq.leetcode.daily._20200426;

/**
 * @author chen
 * @date 2021-04-26
 **/
public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0) {
            return 0;
        }
        final int length = weights.length;
        if (length < D) {
            int ans = weights[0];
            for (int i = 1; i < length; i++) {
                ans = Math.max(ans, weights[i]);
            }
            return ans;
        }

        // 二分 借助前缀和优化
        // 确定边界并求前缀和
        int left = weights[0], right = left;
        for (int i = 1; i < length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        // weights 的货物必须按照顺序
        while (left <= right) {
            int mid = (left + right) >> 1;
            final int day = day(mid, weights);
            // 载重不够
            if (day > D) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int day(int capacity, int[] weights) {
        int ans = 1, curr = weights[0];
        for (int i = 1; i < weights.length; i++) {
            curr += weights[i];
            if (curr > capacity) {
                curr = weights[i];
                ans++;
            }
        }
        return ans;
    }
}
