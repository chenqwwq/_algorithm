package top.chenqwwq.leetcode.contest.weekly._381._1;

import java.util.HashMap;

/**
 * @author chenqwwq
 * @date 2024/1/21
 **/
public class Solution {

    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0, cur = 1;
        while (n > 0) {
            final int m = Math.min(n, 8);
            ans += cur * m;
            n -= m;
            cur++;
        }
        return ans;
    }
}