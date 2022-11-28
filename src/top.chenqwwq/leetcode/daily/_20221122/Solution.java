package top.chenqwwq.leetcode.daily._20221122;

/**
 * @author chenqwwq
 * @date 2022/11/22
 **/
public class Solution {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static final int mod = (int) (1e9 + 7);

    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = a / gcd(a, b) * b;
        long l = 0, r = (long) Math.max(a, b) * n;
        while (l <= r) {
            long mid = l + ((r - l) >> 1);
            if (mid / a + mid / b - mid / lcm >= n) r = mid;
            else l = mid;
        }
        return (int) (r % mod);
    }
}
