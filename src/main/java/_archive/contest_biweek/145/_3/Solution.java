package top.chenqwwq.leetcode.contest.biweek._145._3;

import java.util.*;

/**
 * @author chenqwwq
 * @date 2024/12/11
 **/
public class Solution {
    private static final int NMAX = 100000;

    // 静态统计质数列表
    private static final Set<Integer> PS = new HashSet<>();

    static {
        for (int i = 2; i <= NMAX; i++) {
            if (isPrime(i)) {
                PS.add(i);
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    public int minOperations(int n, int m) {
        if (PS.contains(n) || PS.contains(m)) return -1;
        final Set<Integer> vis = new HashSet<>();
        final PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{n, n});
        while (!pq.isEmpty()) {
            final int[] xs = pq.poll();
            final int x = xs[0], y = xs[1];
            if (x == m) return y;
            int t = x, level = 0;
            while (t > 0) {
                // 当前数位
                int d = t % 10;
                t /= 10;
                final int pow = (int) Math.pow(10, level);
                if (d > 0) {
                    // 可以-
                    int target = x - pow;
                    if (!vis.contains(target) && !PS.contains(target)) {
                        vis.add(target);
                        pq.add(new int[]{target, y + target});
                    }
                }
                if (d < 9) {
                    // 可以+
                    int target = x + pow;
                    if (!vis.contains(target) && !PS.contains(target)) {
                        vis.add(target);
                        pq.add(new int[]{target, y + target});
                    }
                }
                level++;
            }
        }
        return -1;
    }
}