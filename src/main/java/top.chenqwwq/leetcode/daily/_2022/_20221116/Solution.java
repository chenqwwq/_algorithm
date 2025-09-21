package top.chenqwwq.leetcode.daily._2022._20221116;

/**
 * @author chenqwwq
 * @date 2022/11/16
 **/
public class Solution {
    public boolean isIdealPermutation(int[] nums) {
        final int n = nums.length;
        int max = nums[0];
        for (int i = 2; i < n; i++) {
           if(max > nums[i]) return false;
           max = Math.max(max,nums[i-1]);
        }
        return true;
    }
}
