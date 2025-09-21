package top.chenqwwq.leetcode.contest.weekly._372._3;

import java.math.BigDecimal;

/**
 * @author chenqwwq
 * @date 2023/11/19
 **/
public class Solution {
    private static final long mod = (int) (1e9 + 7);

    public int maximumXorProduct(long a, long b, int n) {
        // 保证a < b
        if (a > b) {
            long c = a;
            a = b;
            b = c;
        }
        for (int i = 0; i < n; i++) {
            if (((a >> i) & 1) == 0 && 0 == ((b >> i) & 1)) {
                // 如果都为0，可以同时变为1
                a += (1L << i);
                b += (1L << i);
            } else if (((a >> i) & 1) == 0 && (a + (1L << i)) < b) {
                a += (1L << i);
                b -= (1L << i);
            }
        }
        return (int) (((a % mod) * (b % mod)) % mod);
    }
}