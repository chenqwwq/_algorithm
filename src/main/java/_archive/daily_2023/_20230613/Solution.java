package top.chenqwwq.leetcode.daily._2023._20230613;

/**
 * @author 沽酒
 * @since 2023/06/13
 */
public class Solution {
    public int unequalTriplets(int[] nums) {
        final int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) ans++;
                }
            }
        }
        return ans;
    }
}