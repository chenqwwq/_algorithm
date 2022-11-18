package top.chenqwwq.leetcode.daily._20221118;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/11/18
 **/
public class Solution {
    int mod = (int) 1e9 + 7;

    public int sumSubseqWidths(int[] nums) {
        if (nums.length <= 1) return 0;
        final int n = nums.length;
        var pow2 = new int[n];
        pow2[0] = 1;
        for (var i = 1; i < n; ++i)
            pow2[i] = pow2[i - 1] * 2 % mod;
        // 排序
        Arrays.sort(nums);
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            // 往前是最大值，往后是最小值
            long num = nums[i];
            ans += num * (pow2[i] - pow2[n - i - 1]);
        }
        return (int) (ans % mod + mod) % mod;
    }
}