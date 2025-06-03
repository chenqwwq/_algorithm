package top.chenqwwq.leetcode.contest.weekly._431._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2025/1/5
 **/
public class Solution {
    public int maxLength(int[] nums) {
        // 数据范围很小直接暴力枚举

        // 取最大值和全部数字的
        int mx = Arrays.stream(nums).max().getAsInt();
        int allLcm = 1;
        for (int x : nums) {
            allLcm = lcm(allLcm, x);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int m = 1,l = 1,g = 0;
            for (int j = i; j < nums.length && m <= allLcm * mx; j++) {
                int x = nums[j];
                m *= x;
                l = lcm(l, x);
                g = gcd(g, x);
                if (m == l * g) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

}