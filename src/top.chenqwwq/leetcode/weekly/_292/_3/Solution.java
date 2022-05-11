package top.chenqwwq.leetcode.weekly._292._3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/5/8
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    Map<String, Integer> memo = new HashMap<>();

    int dfs(int n, int min) {
        if (n == 0) {
            return 1;
        }
        String key = n + "-" + min;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ans = 0;
        for (int i = 1; i <= Math.min(min, n); i++) {
            ans = (ans + dfs(n - i, min)) % mod;
        }
        memo.put(key, ans);
        return ans;
    }

    public int countTexts(String pressedKeys) {
        final int n = pressedKeys.length();
        long ans = 1;
        int l = 0, r = 0;
        while (l < n) {
            while (r < n && pressedKeys.charAt(r) == pressedKeys.charAt(l)) {
                r++;
            }
            int num = pressedKeys.charAt(l) - '0';
            ans = (ans * dfs(r - l, (num != 7 && num != 9) ? 3 : 4)) % mod;
            l = r;
        }
        return (int) (ans % mod);
    }
}