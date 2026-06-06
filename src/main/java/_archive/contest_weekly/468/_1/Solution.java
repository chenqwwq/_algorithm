package top.chenqwwq.leetcode.contest.weekly._468._1;

/**
 * @author chenqwwq
 * @date 2025/9/23
 **/
public class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                ans |= num;
            }
        }
        return ans;
    }
}