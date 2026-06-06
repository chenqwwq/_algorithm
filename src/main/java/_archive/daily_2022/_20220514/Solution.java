package top.chenqwwq.leetcode.daily._2022._20220514;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/5/14
 **/
public class Solution {
    private static final int INF = 0x3f3f3f3f;
    int n, maxn;
    int[] memo, targetHash = new int[26];
    int[][] ssHash;

    public int minStickers(String[] stickers, String target) {
        n = stickers.length;
        maxn = 1 << n;
        memo = new int[maxn];
        Arrays.fill(memo, INF);
        int tt = 0;
        for (char c : target.toCharArray()) {
            targetHash[c - 'a']++;
            tt |= (1 << (c - 'a'));
        }
         ssHash = new int[n][26];
        int[] ts = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                ssHash[i][c - 'a']++;
                ts[i] |= (1 << (c - 'a'));
            }
        }
        dfs(targetHash, tt, ssHash, ts, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int ans = Integer.MAX_VALUE;

    private boolean isOk(int[] nums) {
        for (int num : nums) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }

    private int op(int[] a, int[] b, boolean add) {
        int state = 0;
        for (int i = 0; i < a.length; i++) {
            if (add) {
                a[i] += b[i];
            } else {
                a[i] -= b[i];
            }
            if (a[i] > 0) {
                state |= (1 << i);
            }
        }
        return state;
    }

    private void dfs(int[] th, int tt, int[][] hs, int[] ts, int curr) {
        if (isOk(th)) {
            ans = Math.min(ans, curr);
            return;
        }
        for (int i = 0; i < hs.length; i++) {
            if ((tt & ts[i]) == 0) {
                continue;
            }
            int newState = op(th, hs[i], false);
            dfs(th, newState, hs, ts, curr + 1);
            op(th, hs[i], true);
        }
    }

    public static void main(String[] args) {
        new Solution().minStickers(new String[]{"with", "example", "science"},
                "thehat");
    }
}