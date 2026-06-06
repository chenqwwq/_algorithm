package top.chenqwwq.leetcode.contest.weekly._479._2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2025/12/7
 **/
public class Solution {

    private static final List<Integer> ss = sieve(500001);
    private static final Set<Integer> vis = new HashSet<>(ss);

    public int largestPrime(int n) {
        if (n < 2) return 0;
        int ans = 0, cur = 0;
        for (int num : ss) {
            cur += num;
            if (cur > n) break;
            if (vis.contains(cur)) {
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public static List<Integer> sieve(int n) {
        // 边界校验：小于 2 的数没有质数
        if (n < 2) {
            return new ArrayList<>(); // 或抛出异常：throw new IllegalArgumentException("n 必须大于等于 2");
        }

        // 1. 初始化标记数组：isPrime[i] 表示 i 是否为质数，初始时默认所有数都是质数（0/1 后续修正）
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // 2. 核心筛法逻辑：从 2 开始，标记每个质数的倍数为非质数
        // 只需遍历到 sqrt(n)，因为若 n 有大于 sqrt(n) 的因数，其对应另一个因数必然小于 sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) { // 仅当 i 是质数时，标记其倍数
                // 从 i*i 开始标记（i*2、i*3... 已被更小的质数标记过）
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 3. 收集所有质数
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}