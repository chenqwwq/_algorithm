package top.chenqwwq.leetcode.daily._2022._20220818;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2022/8/18
 **/
public class Solution {
    final int N = (int) (1e5 + 10);

    public int maxEqualFreq(int[] nums) {
        final int n = nums.length;
        // 数字 i 一共出现多少次，计数 j 一共出现多少次
        final int[] map = new int[N], sum = new int[N];
        int ans = 0;
        int cc = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i], cur = ++map[t];
            sum[cur]++;
            sum[cur - 1] = Math.max(0, sum[cur - 1] - 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5});
    }
}