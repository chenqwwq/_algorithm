package top.chenqwwq.leetcode.daily._2024._20241225;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/12/25
 **/
public class Solution {
    public int minimumCost(int m, int n, int[] hs, int[] vs) {
        // 先按照代价排序
        Arrays.sort(hs);Arrays.sort(vs);
        m--;n--;
        int ans = 0;
        for (int i = 1, j = 1; i <= m || j <= n; ) {
            if (m >= i && n >= j && hs[m - i] > vs[n - j]) {
                ans += hs[m - i] * j;
                i++;
            } else if (n >= j) {
                ans += vs[n - j] * i;
                j++;
            } else {
                ans += hs[m - i] * j;
                i++;
            }
        }
        return ans;
    }
}