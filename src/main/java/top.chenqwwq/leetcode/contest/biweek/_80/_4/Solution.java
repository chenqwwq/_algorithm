package top.chenqwwq.leetcode.contest.biweek._80._4;

/**
 * @author chenqwwq
 * @date 2022/6/11
 **/
public class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            int l = i, r = n;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                int len = mid - i + 1;
                long sum = pre[mid] - pre[i - 1];
                if (len * sum >= k) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            ans += l - i;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().countSubarrays(new int[]{2, 1, 4, 3, 5}, 10);
    }
}