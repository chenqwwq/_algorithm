package top.chenqwwq.leetcode.daily._2024._20240723;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2024/7/23
 **/
class Solution {

    int mod = (int) 1e9 + 7;
    Map<String, Long> memo = new HashMap<>();
    int[] nums;
    int n;

    public int sumOfPowers(int[] nums, int k) {
        n = nums.length;
        Arrays.sort(nums);
        this.nums = nums;

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dfs(i, i, k - 1, Integer.MAX_VALUE)) % mod;
        }
        return (int) (ans % mod);
    }

    private Long dfs(int cur, int pre, int k, int md) {
        if (k <= 0) return (long) md;
        if (cur >= n || n - cur < k) return 0L;
        final String state = cur + "-" + pre + "-" + k + "-" + md;
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        // 不选当前节点
        Long ans = dfs(cur + 1, pre, k, md);
        // 选择当前节点
        ans = (ans + dfs(cur + 1, cur, k - 1, Math.min(md, Math.abs(nums[pre] - nums[cur])))) % mod;
        memo.put(state, ans);
        return ans;
    }
}