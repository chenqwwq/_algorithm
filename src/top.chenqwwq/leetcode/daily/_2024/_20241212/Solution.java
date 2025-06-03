package top.chenqwwq.leetcode.daily._2024._20241212;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenqwwq
 * @date 2024/12/12
 **/
public class Solution {
    public long maxSpending(int[][] vs) {
        long ans = 0;
        final int n = vs.length, m = vs[0].length;
        final PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> vs[o[0]][o[1]]));
        final int[] idx = new int[n];
        Arrays.fill(idx, m - 1);
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, m - 1});
        }
        for (int i = 1; i <= n * m; i++) {
            final int[] is = queue.poll();
            ans += (long) i * vs[is[0]][is[1]];
            if (--idx[is[0]] >= 0) {
                queue.add(new int[]{is[0], idx[is[0]]});
            }
        }
        return ans;
    }
}