package top.chenqwwq.leetcode.daily._2024._20241005;

/**
 * @author chenqwwq
 * @date 2024/10/5
 **/
public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0, r = Long.MAX_VALUE >> 1;
        while (l < r) {
            final long mid = (l + r) >> 1;
            if (check(mid, time, totalTrips)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public boolean check(long t, int[] ts, long total) {
        for (int tt : ts) {
            if ((total -= (t / tt)) < 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 530554783
        // 100000000000
        new Solution().minimumTime(new int[]{39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50, 13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100, 15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26, 63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25}, 4187);
    }
}