package top.chenqwwq.leetcode.contest.weekly._339._3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2023/4/2
 **/
public class Solution {
    public int miceAndCheese(int[] r1, int[] r2, int k) {
        int n = r1.length;
        int[][] dif = new int[n][2];
        for (int i = 0; i < n; i++) {
            dif[i] = new int[]{i, r1[i] - r2[i]};
        }
        Arrays.sort(dif, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = r2[dif[i][0]];
            if (i < k) cur += dif[i][1];
            ans += cur;
        }
        return ans;
    }
}