package top.chenqwwq.leetcode.contest.weekly._356._2;

/**
 * @author chenqwwq
 * @date 2023/7/30
 **/
public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        final int n = nums.length;
        int cnt = 0;
        int[] vis = new int[2001];
        for (int num : nums) {
            if (++vis[num] == 1) cnt++;
        }

        int ans = 0, t = 0;
        int[] hash = new int[2001];
        for (int l = 0, r = 0; r < n; r++) {
            if (++hash[nums[r]] == 1) t++;
            if (t == cnt) {
                ans += (n - r);
                while (l <= r) {
                    if (--hash[nums[l++]] <= 0) {
                        t--;
                        break;
                    }
                    ans += (n - r);
                }
            }

        }
        return ans;
    }
}