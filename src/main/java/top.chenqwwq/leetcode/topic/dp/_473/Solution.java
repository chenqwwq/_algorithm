package top.chenqwwq.leetcode.topic.dp._473;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/5/18
 **/
public class Solution {
    int[] nums;
    int n;

    public boolean makesquare(int[] nums) {
        final int n = nums.length;
        if (n < 4) {
            return false;
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 4 != 0) {
            return false;
        }
        // 不能直接统计所有等于 total / 4 的种数, [1,1,1,1,1,1,1,1,1] 这种就炸了
        // 直接以记忆化递归扫状态
        Arrays.sort(nums);
        return dfs(0, new boolean[(1 << n) + 1], total >> 2, 0);
    }

    private boolean dfs(int mask, boolean[] vis, int target, int curr) {
        if (vis[mask]) {
            return false;
        }
        if (mask == (1 << n) - 1) {
            return true;
        }
        vis[mask] = true;
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 1) {
                continue;
            }
            int sum = curr + nums[i];
            if (sum > target) {
                return false;
            }
            if (dfs(mask | (1 << i), vis, target, sum == target ? 0 : sum)) {
                return true;
            }
        }
        return false;
    }
}