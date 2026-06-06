package top.chenqwwq.leetcode.contest.weekly._493._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/3/21
 **/
public class Solution {
    public static void main(String[] args) {
        new Solution().longestArithmetic(new int[]{45165, 45154, 42337, 45132, 45121, 45110});
//        new Solution().longestArithmetic(new int[]{45318, 41616, 88168, 34212, 96417, 26808, 23106, 67752, 15702});
    }

    public int longestArithmetic(int[] nums) {
        final int n = nums.length;
        if (n < 3) return 0;

        int[] diff = new int[n];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }

        // 处理差值数列
        int cur = diff[0], cnt = 1;
        final List<int[]> l = new ArrayList<>();      // diff,l,r
        for (int i = 1; i < n - 1; i++) {
            if (cur == diff[i]) cnt++;
            else {
                l.add(new int[]{cur, i - cnt, i});
                cnt = 1;
                cur = diff[i];
            }
        }

        if (cnt != 0) l.add(new int[]{cur, n - cnt - 1, n - 1});
        if (l.size() == 1) return n;

        int ans = 0;
        for (int i = 0; i < l.size(); i++) {
            // 检查前后是否有可以拼接的
            int[] ll = l.get(i);
            ans = Math.max(ans, ll[2] - ll[1] + 2);      // 起码可以扩充一个点
            // 从左往右遍历,所以此时只考虑后面是否可以衔接
            int rd = ll[2], ld = ll[1];
            if (ld - 2 >= 0 && nums[ld] - nums[ld - 2] == ll[0] << 1) ans = Math.max(ans, ll[2] - ll[1] + 3);
            if (rd + 2 < n && nums[rd + 2] - nums[rd] == ll[0] << 1) {
                ans = Math.max(ans, ll[2] - ll[1] + 3);
                if (i + 3 < l.size() && rd + 2 == l.get(i + 3)[1] && l.get(i + 3)[0] == ll[0]) {
                    ans = Math.max(ans, l.get(i + 3)[2] - ld + 1);
                }
            }
        }


        return ans;
    }
}