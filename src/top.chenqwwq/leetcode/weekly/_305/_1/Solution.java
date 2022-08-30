package top.chenqwwq.leetcode.weekly._305._1;

/**
 * @author chenqwwq
 * @date 2022/8/7
 **/
public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        final int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] != diff) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - nums[j] == diff) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}