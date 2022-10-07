package top.chenqwwq.leetcode.contest.cnunionpay2022._3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/9/19
 **/
public class Solution {
    public int storedEnergy(int storeLimit, int[] power, int[][] supply) {
        final int n = power.length, m = supply.length;
        int ans = 0, pos = 0;
        int[] sp = null;
        for (int i = 0; i < n; i++) {
            if (sp == null || (pos < m && i >= supply[pos][0])) sp = supply[pos++];
            if (power[i] < sp[1]) ans -= Math.min(ans, sp[1] - power[i]);
            else if (power[i] > sp[2]) ans = Math.min(storeLimit, ans + power[i] - sp[2]);
        }
        return ans;
    }

}