package top.chenqwwq.leetcode.contest.weekly._360._2;

import javax.swing.plaf.IconUIResource;

/**
 * @author chenqwwq
 * @date 2023/8/27
 **/
public class Solution {
    public long minimumPossibleSum(int n, int target) {
        long ans = 0;
        int cur = 1;
        for (; cur <= n && cur <= (target >> 1); cur++) ans += cur;
        while (cur++ <= n) ans += target++;
        return ans;
    }
}