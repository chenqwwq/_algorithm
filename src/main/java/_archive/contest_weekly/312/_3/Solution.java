package top.chenqwwq.leetcode.contest.weekly._312._3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/9/25
 **/
public class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        final int n = nums.length;
        int[] incr = new int[n], desc = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) desc[i] = desc[i - 1] + 1;
            if (nums[n - i] >= nums[n - i - 1]) incr[n - i - 1] = incr[n - i] + 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (desc[i - 1] >= k - 1 && incr[i + 1] >= k - 1) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().goodIndices(new int[]{2, 1, 1, 1, 3, 4, 1}, 2);
    }
}
