package top.chenqwwq.leetcode.contest.biweek._175._2;

/**
 * @author chenqwwq
 * @date 2026/2/2
 **/
public class Solution {
    public int minimumK(int[] nums) {
        int l = 1, r = 100001;
        while (l <= r) {
            int mid = 1 + l + r >> 1;
            if (check(nums, mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean check(int[] nums, int k) {
        final int cnt = get(nums, k);
        return cnt <= (long) k * k;
    }

    private int get(int[] nums, int k) {
        int cnt = 0;
        for (int num : nums) {
            cnt += num / k;
            if (num % k != 0) cnt++;
        }
        return cnt;
    }
}