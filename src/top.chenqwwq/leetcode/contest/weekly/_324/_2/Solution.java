package top.chenqwwq.leetcode.contest.weekly._324._2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/12/18
 **/
public class Solution {
    static int N = (int) 1e5 + 10;
    static List<Integer> primes = new ArrayList<>();
    static Set<Integer> primeSet = new HashSet<>();

    static {
        for (int i = 2; i <= N; i++) {
            boolean ok = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                primes.add(i);
                primeSet.add(i);
            }
        }
    }

    public int smallestValue(int n) {
        if(n == 4) return 4;
        if (primeSet.contains(n)) return n;
        int sum = 0;
        while (n != 0) {
            for (final Integer num : primes) {
                if (num == n) {
                    sum += num;
                    n -= num;
                    break;
                } else if (n % num == 0) {
                    sum += num;
                    n /= num;
                    break;
                }
            }
        }
        return smallestValue(sum);
    }

    public static void main(String[] args) {
        final int i = new Solution().smallestValue(8);
        System.out.println(i);
    }
}