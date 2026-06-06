package top.chenqwwq.leetcode.contest.weekly._322._2;

/**
 * @author chenqwwq
 * @date 2022/12/8
 **/
public class Solution {
    private static final int N = 1010;

    public long dividePlayers(int[] skill) {
        final int n = skill.length;
        final int k = n >> 1;
        int[] hash = new int[N];
        int sum = 0;
        for (int s : skill) {
            sum += s;
            hash[s]++;
        }
        if (sum % k != 0) return -1;
        int avg = sum / k;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            if (hash[i] == 0) continue;
            while (hash[i]-- > 0) {
                if (hash[avg - i]-- <= 0) return -1;
                ans += (long) i * (avg - i);
            }
        }
        return ans;

    }
}