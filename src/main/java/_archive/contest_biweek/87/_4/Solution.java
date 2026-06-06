package top.chenqwwq.leetcode.contest.biweek._87._4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenqwwq
 * @date 2022/9/17
 **/
public class Solution {
    public long minimumMoney(int[][] ts) {
        final int n = ts.length;
        long ans = 0, cur = 0;
        // t[1] 转化为收益
        for (int[] t : ts) t[1] -= t[0];
        Arrays.sort(ts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] <= 0 && o2[1] > 0) return -1;
                else if (o1[1] > 0 && o2[1] < 0) return 1;
                else {
                    if (o1[1] <= 0) return Integer.compare(o1[0] + o1[1], o2[1] + o2[0]);
                    else return Integer.compare(o2[0],o1[0]);
                }
            }
        });
        for (int i = 0; i < n; i++) {
            if (cur < ts[i][0]) {
                ans += ts[i][0] - cur;
                cur = ts[i][0] + ts[i][1];
            } else {
                cur += ts[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().minimumMoney(new int[][]{{7,2},{0,10},{5,0},{4,1},{5,8},{5,9}});
    }
}