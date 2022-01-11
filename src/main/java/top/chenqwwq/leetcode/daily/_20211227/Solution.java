package top.chenqwwq.leetcode.daily._20211227;

import java.util.Arrays;

/**
 * @author chenbingxin
 * @date 2021/12/27
 **/
public class Solution {

    public int numFriendRequests(int[] ages) {
        final int n = ages.length;
        Arrays.sort(ages);

        int ans = 0;
        // age[x] >= age[y]
        // age[x] <= (age[y] - 7) * 2
        for (int i = n - 1; i > 0; i--) {
            if (i + 1 < n && ages[i] == ages[i + 1]) {
                continue;
            }
            final double target = calculate(ages[i]);
            final int ceiling = ceiling(ages, 0, i, target);
            if (ceiling >= i) {
                continue;
            }
            int cnt = 1, t = i;
            while (t - 1 >= 0 && ages[t] == ages[--t]) {
                cnt++;
            }
            final int diff = i - ceiling;
            ans += diff == 0 ? (cnt > 1 ? cnt : 0) : cnt * diff;
        }
        return ans;
    }

    private int ceiling(int[] ages, int l, int r, double target) {
        while (l <= r) {
            final int mid = (l + r) >> 1;
            if (ages[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private double calculate(int num) {
        return 0.5 * num + 7;
    }
}