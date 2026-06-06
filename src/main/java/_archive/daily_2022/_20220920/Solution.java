package top.chenqwwq.leetcode.daily._2022._20220920;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2022/9/20
 **/
public class Solution {
    int n, avg, k;
    int[] nums;
    boolean[] vis;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum % k) != 0) return false;
        avg = sum / k;
        Arrays.sort(nums);
        if (nums[n - 1] > avg) return false;
        vis = new boolean[1 << n];
        return dfs(0, 0);
    }

    private boolean dfs(int status, int cur) {
        if (status == (1 << n) - 1) return true;
        if (vis[status]) return false;
        vis[status] = true;
        for (int i = 0; i < n; i++) {
            if (cur + nums[i] > avg) break; // 经过排序之后可以直接跳出
            if (((status >> i) & 1) == 0 && dfs(status | (1 << i), (cur + nums[i]) % avg)) {
                return true;
            }
        }
        return false;
    }
}