package top.chenqwwq.leetcode.contest.weekly._483._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2026/1/5
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().minimumCost("100101", "111110", 66, 82, 237798794);
    }

    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        final int n = s.length();
        long ans = Long.MAX_VALUE;
        List<Character> cs1 = new ArrayList<>();
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (c1 == c2) continue;      // 当前字符相同就跳过
            if (c1 == '0') cnt0++;
            else cnt1++;
            cs1.add(c1);
        }

        // 1. 直接 flip
        ans = Math.min(ans, (long) cs1.size() * flipCost);

        // 2. 先swap ,再 flip
        ans = Math.min(ans, (long) Math.min(cnt0, cnt1) * swapCost + (long) (cs1.size() - Math.min(cnt0, cnt1)) * flipCost);

        // 3.  先 cross，再 swap，再 flip
        int dif = Math.abs(cnt1 - cnt0);
        // cross  翻转 dif /2 个
        long t1 = (long) dif / 2 * crossCost;
        // swap min(cnt0,cnt1) + dif / 2 个
        t1 += (long) (Math.min(cnt0, cnt1) + dif / 2) * swapCost;
        // 剩下的一个需要 flip
        if (dif % 2 == 1) t1 += flipCost;

        ans = Math.min(ans, t1);
        return ans;
    }
}