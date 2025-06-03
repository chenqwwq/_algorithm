package top.chenqwwq.leetcode.daily._2025._20250329;

/**
 * @author chenqwwq
 * @date 2025/3/29
 **/
public class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int ans = -1;
        int st = 1;    // 当前遍历开始时间
        int[] vt = new int[n]; // 每个节点的访问时间

        // 因为一个节点最多只有一个出边,所以一个节点最多只能在一个环,所以访问过的节点可以直接忽略
        for (int i = 0; i < n; i++) {
            if (edges[i] == -1) continue;
            int cur = i, time = st;
            while (cur != -1 && vt[cur] == 0) {     // 节点没有被访问过
                vt[cur] = st++;
                cur = edges[cur];
            }
            if (cur != -1 && vt[cur] >= time) {
                ans = Math.max(ans, st - vt[cur]);
            }
        }
        return ans;
    }
}