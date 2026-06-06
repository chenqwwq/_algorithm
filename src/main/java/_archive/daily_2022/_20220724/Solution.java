package top.chenqwwq.leetcode.daily._2022._20220724;

/**
 * @author chenqwwq
 * @date 2022/7/24
 **/
public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        final int n = distance.length;
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = distance[i] + ps[i];
        }
        int a = Math.min(start, destination), b = Math.max(start, destination);
        return Math.min(ps[b] - ps[a], ps[n] - ps[b] - ps[a]);
    }
}