package top.chenqwwq.leetcode.lcof2._103_$;

/**
 * @author chenbingxin
 * @date 2022/1/3
 **/
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return dfs(coins, amount, new int[amount]);
    }

    public int dfs(int[] coins, int remain, int[] cache) {
        if (remain < 0) {
            return -1;
        }
        if (remain == 0) {
            return 0;
        }
        if (cache[remain - 1] != 0) {
            return cache[remain - 1];
        }

        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            final int res = dfs(coins, remain - coin, cache);
            if (res >= 0 && res < ans) {
                ans = 1 + res;
            }
        }
        cache[remain - 1] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return cache[remain - 1];
    }
}
