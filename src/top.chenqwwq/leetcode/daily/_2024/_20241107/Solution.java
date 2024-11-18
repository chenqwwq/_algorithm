package top.chenqwwq.leetcode.daily._2024._20241107;

import java.util.Arrays;

/**
 * @author chenqwwq
 * @date 2024/11/7
 **/
public class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length, m = n - k + 1;
        final int[] ans = new int[m];
        Arrays.fill(ans, -1);
        int l = 0, r = 0, cnt = 0;
        while (++r < n) {
            // 当前两个数为递增
            if (nums[r] > nums[r - 1]) cnt++;
            // 当前连续数组是否大于K
            if (cnt >= k) ans[r - k - 1] = nums[r];
            // 窗口收缩
            while (r - l + 1 >= k) {
                if (nums[l] < nums[++l]) cnt--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3);
    }
}