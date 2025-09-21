package top.chenqwwq.leetcode.contest.weekly._388._1;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/3/10
 **/
public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int cnt : apple) sum += cnt;
        Arrays.sort(capacity);
        final int n = capacity.length;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(sum > 0) ans++;
            sum -= capacity[i];
        }
        return ans;
    }
}