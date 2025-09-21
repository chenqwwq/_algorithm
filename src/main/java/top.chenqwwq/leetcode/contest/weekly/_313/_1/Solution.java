package top.chenqwwq.leetcode.contest.weekly._313._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenqwwq
 * @date 2022/10/10
 **/
public class Solution {
    public int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int ans = 0;
        for (int i = 2; i <= min; i++) {
            if (a % i == 0 && b % i == 0) ans++;
        }
        return ans;
    }
}