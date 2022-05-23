package top.chenqwwq.leetcode.daily._20220522;

/**
 * @author chenqwwq
 * @date 2022/5/22
 **/
public class Solution {
    int maxn = 20;
    Boolean[] dp = new Boolean[1 << maxn];

    public boolean canIWin(int n, int d) {
        if (n >= d) {
            return true;
        }
        if((1 + n) * n / 2 < d){
            return false;
        }
        return dfs(0, d, n);
    }

    private boolean dfs(int state, int d, int n) {
        if (dp[state] != null) {
            return dp[state];
        }

        for (int i = 0; i < n; i++) {
            if (((state >> i) & 1) == 1) {
                continue;
            }
            if (i + 1 >= d || !dfs(state | (1 << i), d - i - 1, n)) {
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }
}