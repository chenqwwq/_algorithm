package top.chenqwwq.leetcode.contest.weekly._474._3;

/**
 * @author chenqwwq
 * @date 2025/11/2
 **/
public class Solution {
    public long minimumTime(int[] d, int[] rr) {
        long l = 1, r = Long.MAX_VALUE - 1;
        while (l < r) {
            long mid = (l + r) >> 1;
            boolean res = check(d, rr, mid);
            if (res) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] d, int[] r, long t) {
        final long k1 = t / r[0];     // 1的充电次数
        final long r1 = t - k1;       // 留给1的空位
        final long k2 = t / r[1];
        final long r2 = t - k2;       // 留给2的空位

        if (r2 < d[1] || r1 < d[0]) return false;   // 自己都不够

        // 两边穿插
        long cnt = countDivisible(r[0], r[1], t);

        // 对方不行的先填满
        long d1 = d[1] - k1 + cnt;
        long d0 = d[0] - k2 + cnt;
        return t - cnt - (k1 - cnt) - (k2 - cnt) >= d0 + d1;    // r1,r2 就是双方选一的个数
    }

    // 计算最大公约数（GCD）使用辗转相除法[8](@ref)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 主方法：计算小于等于k的数中能同时整除x和y的数的个数
    public static long countDivisible(int x, int y, long k) {
        // 处理无效输入（x、y需为正整数，k至少为1）
        if (x <= 0 || y <= 0 || k < 1) {
            return 0;
        }

        // 计算GCD和LCM[6,8](@ref)
        int gcd = gcd(x, y);
        int lcm = (x / gcd) * y; // 先除后乘避免溢出

        // 如果LCM大于k，则没有符合条件的数
        if (lcm > k) {
            return 0;
        }

        // 返回倍数个数（整数除法自动向下取整）
        return k / lcm;
    }
}