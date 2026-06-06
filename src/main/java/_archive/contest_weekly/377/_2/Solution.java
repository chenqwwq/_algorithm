package top.chenqwwq.leetcode.contest.weekly._377._2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2023/12/24
 **/
public class Solution {
    private static final int mod = (int) 1e9 + 7;

    public int maximizeSquareArea(int m, int n, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);
        Set<Long> vs = new HashSet<>(), hs = new HashSet<>();
        hs.add((long) (m - 1));
        vs.add((long) (n - 1));
        for (int i = 0; i < h.length; i++) {
            hs.add((long) (h[i] - 1));
            hs.add((long) (m - h[i]));
            for (int j = i + 1; j < h.length; j++) {
                hs.add((long) (h[j] - h[i]));
            }
        }
        for (int i = 0; i < v.length; i++) {
            vs.add((long) (v[i] - 1));
            vs.add((long) (n - v[i]));
            for (int j = i + 1; j < v.length; j++) {
                vs.add((long) (v[j] - v[i]));
            }
        }
        long ans = -1;
        for (Long vv : vs) {
            if (hs.contains(vv)) {
                ans = Math.max(ans, vv);
            }
        }
        return ans == -1 ? (int)ans : (int) (ans * ans % mod);
    }
}