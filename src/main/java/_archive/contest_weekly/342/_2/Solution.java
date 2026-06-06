package top.chenqwwq.leetcode.contest.weekly._342._2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2023/4/23
 **/
public class Solution {
    static final int N = 1001;

    public int sumOfMultiples(int n) {
        int a = 1, b = 1, c = 1;
        int x = 3, y = 5, z = 7;
        int cur = 0, ans = 0;
        while (cur <= n) {
            ans += cur;
            int q = a * x, p = b * y, w = c * z;
            final int min = getMin(q, p, w);
            cur = min;
            if (min == q) a++;
            if (min == p) b++;
            if (min == w) c++;
        }
        return ans;

    }

    private int getMin(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
}