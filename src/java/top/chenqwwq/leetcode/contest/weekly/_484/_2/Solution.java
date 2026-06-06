package top.chenqwwq.leetcode.contest.weekly._484._2;

/**
 * @author chenqwwq
 * @date 2026/1/11
 **/
public class Solution {
    public int centeredSubarrays(int[] nums) {
        final int n = nums.length;

        int ans = n;        // 单个的肯定都符合
        final int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = i; k < n; k++) {
                    if (ps[k] - ps[j] == nums[i]) ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().centeredSubarrays(new int[]{-1, 1, 0});
    }
}