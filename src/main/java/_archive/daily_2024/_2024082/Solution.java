package top.chenqwwq.leetcode.daily._2024._2024082;

/**
 * @author chenqwwq
 * @date 2024/8/24
 **/
public class Solution {
    public long minEnd(int n, int x) {
        return handler(n, x);
    }

    public long handler(int n, long x) {
        if (n == 1) return x;
        // 需要占用几个0
        // 最小的肯定是 x,所需要的长度直接减1
        int step = 0, m = n - 1;

        // 每个0都是 1 2 4 的可能性
        while (m > Math.pow(2, step)) {
            m -= Math.pow(2, step);
            step++;
        }

        // 将 step + 1 的0置1
        long i = 0;
        while (i < 64 && step >= 0) {
            if ((x & (1L << i)) == 0) step--;
            i++;
        }
        return handler(m, x | (1L << i - 1));
    }
}