package top.chenqwwq.leetcode.contest.weekly._304._3;

import static java.lang.Math.min;

/**
 * @author chenqwwq
 * @date 2022/7/31
 **/
public class Solution {
    private static final int inf = 0x3f3f3f3f;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) return node1;
        // 可能存在环
        final int n = edges.length;
        int ans = -1;
        Integer[] d1 = new Integer[n], d2 = new Integer[n];
        for (int d = 0; node1 != -1 && d1[node1] == null; node1 = edges[node1], d++) {
            d1[node1] = d;
        }
        for (int d = 0; node2 != -1 && d2[node2] == null; node2 = edges[node2], d++) {
            d2[node2] = d;
            if (d1[node2] != null
                    && (ans == -1 || (Math.max(d1[node2],d2[node2]) < Math.max(d1[ans],d2[ans])) || (Math.max(d1[node2],d2[node2]) == Math.max(d1[ans],
                    d2[ans]) && node2 < ans))){
                ans = node2;
            }
        }
        return ans;
    }
}