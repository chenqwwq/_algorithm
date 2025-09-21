package top.chenqwwq.leetcode.contest.weekly._308._3;

/**
 * @author chenqwwq
 * @date 2022/8/28
 **/
public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        final int n = garbage.length;
        int ans = 0; // 总时间
        int m = -1, p = -1, g = -1;
        for (int i = n - 1; i >= 0; i--) {
            ans += garbage[i].length();
            for (char c : garbage[i].toCharArray()) {
                if (c == 'M' && m == -1) m = i;
                else if (c == 'P' && p == -1) p = i;
                else if (c == 'G' && g == -1) g = i;
            }
        }

        final int k = travel.length;
        for (int i = 1; i < k; i++) travel[i] += travel[i - 1];
        if (m > 0) ans += travel[m - 1];
        if (p > 0) ans += travel[p - 1];
        if (g > 0) ans += travel[g - 1];
        return ans;
    }
}