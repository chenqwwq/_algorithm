package top.chenqwwq.leetcode.contest.weekly._337;

import java.util.Arrays;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/3/19
 **/
public class Solution {
    int ans = 0, k, n;
    int[] nums;

    public int beautifulSubsets(int[] _nums, int _k) {
        this.n = _nums.length;
        this.nums = _nums;
        this.k = _k;
        boolean[] exist = new boolean[1001];
        dfs(0, exist);
        return ans;
    }

    private void dfs(int i, boolean[] exist) {
        if (i == n) {
            ans++;
            return;
        }
        // 不选
        dfs(i + 1, exist);

        // 可不可以选
        final boolean canChoose = (nums[i] - k >= 0 && exist[nums[i] - k]) || (nums[i] + k <= 1000 && exist[nums[i] + k]);
        if (canChoose) return;

        // 选
        exist[nums[i]] = true;
        dfs(i + 1, exist);
        exist[nums[i]] = false;
    }
}