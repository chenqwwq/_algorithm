package top.chenqwwq.leetcode.contest.biweek._182._1;

import java.util.Objects;

/**
 * @author chenqwwq
 * @date 2026/5/9
 **/
public class Solution {
    public int[] scoreValidator(String[] events) {
        int[] ans = new int[2];
        for (String e : events) {
            if (Objects.equals(e, "NB") || Objects.equals(e, "WD")) ans[0]++;
            else if (Objects.equals(e, "W")) ans[1]++;
            else ans[0] += e.charAt(0) - '0';

            if (ans[1] == 10) break;
        }
        return ans;
    }
}