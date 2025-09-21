package top.chenqwwq.leetcode.daily._2024._20241002;

/**
 * @author chenqwwq
 * @date 2024/10/2
 **/
public class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        final int n = dist.length;
        if (n - 1 > hour) return -1;
        int l = 1, r = 0x3f3f3f3f;
        while (l < r) {
            int ms = (l + r - 1) >> 1; // 中间速度
            double total = 0;
            for (int i = 0; i < n; i++) {
                if (i != n - 1) total += Math.ceil((double) dist[i] / ms);
                else total += (double) dist[i] / ms;
            }
            if (total <= hour) r = ms;
            else l = ms + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        final int i = new Solution().minSpeedOnTime(new int[]{1, 3, 2}, 2.7);
        System.out.println(i);
    }
}