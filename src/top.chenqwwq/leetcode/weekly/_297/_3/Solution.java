package top.chenqwwq.leetcode.weekly._297._3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2022/6/12
 **/
public class Solution {
    public int distributeCookies(int[] cookies, int k) {
        dfs(0,cookies,new int[k]);
        return ans;
    }

    int ans = Integer.MAX_VALUE;

    private void dfs(int i, int[] cks, int[] sum) {
        if (i >= cks.length) {
            int max = Integer.MIN_VALUE;
            for (int k : sum) {
                max = Math.max(max, k);
            }
            ans = Math.min(ans, max);
            return;
        }
        for (int j = 0; j < sum.length; j++) {
            sum[j] += cks[i];
            dfs(i + 1, cks, sum);
            sum[j] -= cks[i];
        }
    }

}