package top.chenqwwq.leetcode.contest.weekly._437._2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/2/16
 **/
public class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        final int n = pizzas.length;
        int mc = n / 8 + (n % 8 == 0 ? 0 : 1), mn = n / 8;
        int cur = n - 1;
        long ans = 0;
        while (cur > n - mc - 1) {
            ans += pizzas[cur--];
        }
        while (cur > n - mc - mn * 2 - 1) {
            ans += pizzas[cur - 1];
            cur -= 2;
        }
        return ans;
    }
}