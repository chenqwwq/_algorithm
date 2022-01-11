package top.chenqwwq.leetcode.daily._20210430;

/**
 * 137. Single Number II
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * Each element in nums appears exactly three times except for one element which appears once.
 * <p>
 * <p>
 * Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * @author chen
 * @date 2021-04-30
 **/
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += ((num >> i) & 1);
            }
            if (cnt % 3 == 1) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
