package top.chenqwwq.leetcode.contest.weekly._421._1;

/**
 * @author chenqwwq
 * @date 2024/10/27
 **/
public class Solution {
    public long maxScore(int[] nums) {
        final int n = nums.length;
        long ans = 0;

        for (int i = -1; i < n; i++) {
            long g = -1, l = -1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (g == -1 || l == -1) {
                    g = nums[j];
                    l = nums[j];
                } else {
                    g = gcd_division_recursive(g, nums[j]);
                    l = lcm(l, nums[j]);
                }
            }
            ans = Math.max(ans, l * g);
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().maxScore(new int[]{2, 4, 8, 16});
    }

    /**
     * 辗转相除法
     */
    public static long gcd_division_recursive(long a, long b) {
        return b == 0 ? a : gcd_division_recursive(b, a % b);
    }


    /**
     * 求最小公倍数
     */
    public static long lcm(long a, long b) {
        return a / gcd_division_recursive(a, b) * b;
    }
}