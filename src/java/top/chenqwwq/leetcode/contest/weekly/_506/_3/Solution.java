package top.chenqwwq.leetcode.contest.weekly._506._3;

public class Solution {
    int inf = 0x3f3f3f3f;

    public long maxRatings(int[][] units) {
        final int m = units.length, n = units[0].length;
        long ans = 0;
        if (n == 1) {
            for (int i = 0; i < m; i++)
                ans += units[i][0];
            return ans;
        }

        int[][] nums = new int[m][2];
        int mmin = inf;
        for (int i = 0; i < m; i++) {
            int q = inf, p = inf;
            for (int j = 0; j < n; j++) {
                if (units[i][j] < q) {
                    p = q;
                    q = units[i][j];
                } else if (units[i][j] < p) {
                    p = units[i][j];
                }
            }
            nums[i][0] = q;
            nums[i][1] = p;
            mmin = Math.min(mmin, Math.min(q, p));
        }

        int min = inf;
        for (int i = 0; i < m; i++) {
            min = Math.min(nums[i][1], min);
            ans += nums[i][1];
        }
        return ans - min + mmin;
    }
}