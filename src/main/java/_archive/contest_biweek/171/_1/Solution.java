package top.chenqwwq.leetcode.contest.biweek._171._1;

/**
 * @author chenqwwq
 * @date 2025/12/13
 **/
public class Solution {

    public boolean completePrime(int num) {
        String s = String.valueOf(num);
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            if (!checkPrimes(s.substring(i)) || !checkPrimes(s.substring(0, i))) return false;
        }
        return true;
    }

    private boolean checkPrimes(String ns) {
        if (ns.isBlank()) return true;
        int num = Integer.parseInt(ns);
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
