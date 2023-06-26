package top.chenqwwq.leetcode.contest.weekly._351._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 沽酒
 * @since 2023/06/25
 */
public class Solution {
    private static final int mod = (int) 1e9 + 7;

    public int numberOfGoodSubarraySplits(int[] nums) {
        final int n = nums.length;
        List<Integer> list = new ArrayList<>();
        boolean exist = false;
        int cur = 0;
        for (int num : nums) {
            if (num == 1) {
                if (exist) list.add(cur);
                exist = true;
                cur = 0;
                continue;
            }
            cur++;
        }
        if (!exist) return 0;  // 不存在1

        int ans = 1;
        for (int cnt : list) {
            ans = (int) ((long) (cnt + 1) * ans % mod);
        }
        return ans;
    }
}